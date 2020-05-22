import java.util.Map;
import java.util.HashMap;

public class Item {
    private final String name;
    // <CountryName, Price>
    private Map<String, Double> countryPrices;

    public Item(String name) {
        this.name = name;
        this.countryPrices = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }
    public void setPrice(String countryName, double price) {
        this.countryPrices.put(countryName, price);
    }
    public double getPrice(String countryName) {
        return this.countryPrices.get(countryName);
    }
}