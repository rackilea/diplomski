import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class MenuItem {
    private double price;
    private String description;
    private ArrayList<String> category = new ArrayList<>(Arrays.asList("Appetizer", "Main Course", "Dessert"));

    public MenuItem(double price, String description) {
        this.price = price;
        this.description = description;
    }

    public MenuItem(double price, String description, ArrayList<String> category) {
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public ArrayList<String> getCategory() {
        return category;
    }

    public static void main(String... args) {
        MenuItem lobsterRisotto1 = new MenuItem(14.99, "Lobster pasta in buttery red sauce - sample 1");
        MenuItem lobsterRisotto2 = new MenuItem(
                29.99,
                "Lobster pasta in buttery red sauce - sample2",
                new ArrayList<>(Arrays.asList("category1", "category2", "category3")));

        // output: 14.99
        System.out.println(lobsterRisotto1.getPrice());
        // output: 29.99
        System.out.println(lobsterRisotto2.getPrice());

        // output: Appetizer, Main Course, Dessert
        System.out.println(lobsterRisotto1.getCategory().stream().collect(Collectors.joining(", ")));

        // output: category1, category2, category3
        System.out.println(lobsterRisotto2.getCategory().stream().collect(Collectors.joining(", ")));
    }
}