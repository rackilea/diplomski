import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //a list of food
        Scanner in = new Scanner(System.in);
        List<Food> f = new ArrayList<>();
        f.add(new Food("BBQ", 3.35));
        f.add(new Food("KFC", 3.3));
        f.add(new Food("Ga 36", 4.5));
        int n = 3;
        while (true) {
            System.out.print("Enter food name: ");
            String name = in.nextLine();
            System.out.print("Enter food price: ");
            double price = Double.parseDouble(in.nextLine());
            Food food = new Food();
            //f[n].name = name;f[n].price = price;
            food.setName(name);
            food.setPrice(price);
            f.add(food);
            n++;
            System.out.print("Add more food (yes/no)? ");
            String s = in.nextLine();
            System.out.println(s);
            if (s.trim().equalsIgnoreCase("no")) break;
        }
        System.out.print("Enter price of food p:");
        double price = Double.parseDouble(in.nextLine());
        listp(f, price);

    }

    private static void listp(List<Food> f, double priceP) {
        f.stream()
                .filter(food -> food.getPrice() <= priceP)
                .sorted(Comparator.comparingDouble(Food::getPrice))
                .forEach(food -> System.out.printf("%s : %s%n", food.getName(), food.getPrice()));
    }
}