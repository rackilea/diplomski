import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

public class Test
{
    public static void main(String[] args)
    {
        Locale currentLocale = Locale.getDefault();
        Currency currentCurrency = Currency.getInstance(currentLocale);
        Double currencyAmount = new Double(9876543.21);
        NumberFormat currencyFormatter = 
                NumberFormat.getCurrencyInstance(currentLocale);
        System.out.println(NumberFormat.getNumberInstance(currentLocale));
        System.out.println(
                           currentLocale.getDisplayName() + ", " +
                           currentCurrency.getDisplayName() + ": " +
                           currencyFormatter.format(currencyAmount));

        try
        {
            System.out.println(currencyFormatter.parseObject("$9,876,543.21"));
        }
        catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}