import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smv on 19/09/16.
 */
public class MainTest {

    @AllArgsConstructor
    @ToString
    @Data
    class Entity {
        private String customer;
        private String product;
        private String productDetail;
    }

    @AllArgsConstructor
    @ToString
    @Data
    class ProductDetail{
        private String details;
    }

    @AllArgsConstructor
    @ToString
    @Data
    class Product{
        private String product;
        private List<ProductDetail> detailList;
    }

    @AllArgsConstructor
    @ToString
    @Data
    class Customer{
        private String customer;
        private List<Product> productList;
    }
    @Test
    public void run() throws Exception {
        ArrayList<Entity> entities = new ArrayList<>();
        entities.add(new Entity("A", "A1", "A11"));
        entities.add(new Entity("A", "A1", "A12"));
        entities.add(new Entity("A", "A2", "A21"));
        entities.add(new Entity("A", "A2", "A22"));
        entities.add(new Entity("B", "B1", "B11"));
        entities.add(new Entity("B", "B2", "B21"));
        entities.add(new Entity("C", "C1", "C11"));
        entities.add(new Entity("C", "C1", "C12"));

        ArrayList<Customer> customers = new ArrayList<>();
        entities.forEach(entity -> {
            Customer customer = customers.stream().filter(c -> c.getCustomer().equals(entity.getCustomer())).findFirst().orElse(new Customer(entity.getCustomer(), new ArrayList<>()));
            if (!customers.contains(customer)) {
                customers.add(customer);
            }
            Product product = customer.getProductList().stream().filter(p -> p.getProduct().equals(entity.getProduct())).findFirst().orElse(new Product(entity.getProduct(), new ArrayList<>()));
            if (!customer.getProductList().contains(product)) {
                customer.getProductList().add(product);
            }
            ProductDetail productDetail = product.getDetailList().stream().filter(pd -> pd.getDetails().equals(entity.getProductDetail())).findFirst().orElse(new ProductDetail(entity.getProductDetail()));
            if (!product.getDetailList().contains(productDetail)) {
                product.getDetailList().add(productDetail);
            }
        });

        customers.forEach(s -> System.out.println(s));
    }

}