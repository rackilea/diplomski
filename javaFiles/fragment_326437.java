import java.io.IOException;
import java.math.BigDecimal;

import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;
import org.joda.money.IllegalCurrencyException;
import org.joda.money.Money;
import org.joda.money.format.MoneyAmountStyle;
import org.joda.money.format.MoneyFormatter;
import org.joda.money.format.MoneyFormatterBuilder;
import org.joda.money.format.MoneyParseContext;
import org.joda.money.format.MoneyParser;
import org.joda.money.format.MoneyPrintContext;
import org.joda.money.format.MoneyPrinter;

public class MoneyTest {
    private static enum DollarParserPrinter implements MoneyParser,
            MoneyPrinter {
        INSTANCE;

        private static final String DOLLAR_SYMBOL = "$ ";

        @Override
        public void parse(MoneyParseContext context) {
            int endPos = context.getIndex() + 2;
            if (endPos > context.getTextLength()) {
                context.setError();
            } else {
                String code =
                        context.getTextSubstring(context.getIndex(), endPos);
                if(DOLLAR_SYMBOL.equals(code)) {
                    context.setCurrency(CurrencyUnit.USD);
                    context.setIndex(endPos);
                }
            }
        }

        @Override
        public void print(MoneyPrintContext context, Appendable appendable,
                BigMoney money) throws IOException {
            if(CurrencyUnit.USD == money.getCurrencyUnit()) {
                appendable.append(DOLLAR_SYMBOL);
            } else {
                throw new IllegalCurrencyException("This parser only knows how to print US Dollar money!");
            }
        }
    }

    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal("100");
        MoneyFormatter mf =
                new MoneyFormatterBuilder().append(DollarParserPrinter.INSTANCE, DollarParserPrinter.INSTANCE)
                        .appendAmount(MoneyAmountStyle.LOCALIZED_GROUPING)
                        .toFormatter();
        String money_as_string = mf.print(Money.of(CurrencyUnit.USD, bd)); 
        System.out.println(money_as_string);
        Money money = mf.parseMoney(money_as_string);
        System.out.println(money);
    }
}