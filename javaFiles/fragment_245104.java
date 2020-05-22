import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
    Map<String, Currency> currencyMap = new HashMap<String, Currency>();

    public static void main(String[] args) {
        Main main = new Main();
        main.populateCurrencyMap();

        // Getting the corresponding conversion rate and symbol for a currency e.g. USD
        Currency currency = main.currencyMap.get("USD");
        if (currency != null)
            System.out.println("Rate: " + currency.getConvertionRate() + ", Symbol: " + currency.getSymbol());
    }

    void populateCurrencyMap() {
        File file = new File(
                "/Users/arvind.avinash/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/AdHoc/src/currency2.txt");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));

            String line = in.readLine().trim();

            while (line != null) {
                String[] parts = line.split(",");
                String currency = parts[0].trim();
                double rate = Double.parseDouble(parts[1].trim());
                String symbol = parts[2].trim();

                currencyMap.put(currency, new Currency(currency, rate, symbol));
                line = in.readLine();
            }

            in.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}