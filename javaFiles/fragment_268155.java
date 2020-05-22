import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

public class Answer {

    static class Product{
        private String name;
        private int noOfSales;

        public Product(String name, int noOfSales){
            this.name = name;
            this.noOfSales = noOfSales;
        }

        public String getName() {
            return name;
        }
        public int getNoOfSales(){
            return noOfSales;
        }
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product("tea", 4),
                new Product("apple", 12),
                new Product("tea", 15)
        };

        Map<String, IntSummaryStatistics> mapOfProducts =
        Arrays.stream(products)
                .collect(Collectors.groupingBy(
                        Product::getName,
                        Collectors.summarizingInt(Product::getNoOfSales)));

        System.out.println(mapOfProducts);


    }
}