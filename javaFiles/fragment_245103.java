import java.util.HashMap;
import java.util.Map;

class Currency {
    String code;
    double convertionRate;
    String symbol;

    Currency(String code, double convertionRate, String symbol) {
        this.code = code;
        this.convertionRate = convertionRate;
        this.symbol = symbol;
    }

    public double getConvertionRate() {
        return convertionRate;
    }

    public void setConvertionRate(double convertionRate) {
        this.convertionRate = convertionRate;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}

public class Main {
    public static void main(String[] args) {
        Map<String, Currency> currencyMap = new HashMap<String, Currency>();
        // Populate currencyMap with values read from the .txt file e.g.
        currencyMap.put("USD", new Currency("USD", 1.60, "$"));
        // Replace the above line with currencyMap.put(currency_code-from-file,new
        // Currency(currency_code-from-file,conversion_rate-from-file,currency_symbol-from-file));
        // and use it inside the loop which you must be using to read the content from .txt file

        // Getting the corresponding conversion rate and symbol for a currency e.g. USD
        Currency currency = currencyMap.get("USD");
        // Replace the above statement with Currency
        // currency=currencyMap.get(String.valueOf(JComboBox.getSelectedItem()) in your
        // program.
        double convertionRate = currency.getConvertionRate();
        String symbol = currency.getSymbol();
        // Use convertionRate and symbol in your calculation
    }
}