import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static class Ingredient {
        private final String name;
        private final int quantity;

        public Ingredient(String name, int quantity) {
            Objects.requireNonNull(name);
            this.name = name;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }

        @Override
        public String toString() {
            return "Ingredient{" +
                    "name='" + name + '\'' +
                    ", quantity=" + quantity +
                    '}';
        }
    }

    public static void main(String[] args) {
        Ingredient[] ingredients = new Ingredient[]{
            new Ingredient("banana", 1),
            new Ingredient("cherry", 5),
            new Ingredient("banana", 3),
            new Ingredient("floor", 1)
        };

        // First solution: Group all quantities
        Map<String, List<Integer>> collect = Arrays.stream(ingredients)
                .collect(Collectors.groupingBy(Ingredient::getName, 
                        Collectors.mapping(Ingredient::getQuantity, Collectors.toList())
                ));
        System.out.println(collect);

        // Second solution: Sum all quantities
        Map<String, Integer> sum = Arrays.stream(ingredients)
                .collect(
                     Collectors.groupingBy(Ingredient::getName, 
                     Collectors.summingInt(Ingredient::getQuantity)
                ));
        System.out.println(sum);
    }
}