package test;

import java.util.Locale;

import javax.money.CurrencyQuery;
import javax.money.CurrencyQueryBuilder;
import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.format.MonetaryFormats;

import org.javamoney.moneta.FastMoney;

public class TestCurrencyQuery {
  public static void main(String[] args) {
    System.out.println(System.getProperty("java.vm.name"));
    System.out.println(System.getProperty("java.version"));
    System.out.println(System.getProperty("java.specification.vendor"));

    CurrencyQuery query = CurrencyQueryBuilder.of().setCurrencyCodes(getCurrencyCodesFromNumeric(840)).build();
    CurrencyUnit cu = Monetary.getCurrency(query);
    MonetaryAmount amount = FastMoney.of(99.99, cu);
    System.out.println(MonetaryFormats.getAmountFormat(Locale.ENGLISH).format(amount));
  }

    public String[] getCurrencyCodesFromNumeric(int... codes) {
        Collection<String> currencyCodes = // query db and return associated String currency codes;
        return currencyCodes.toArray(new String[currencyCodes.size()]);
    }
}