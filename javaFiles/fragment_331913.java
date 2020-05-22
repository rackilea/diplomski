public class Invertory {

 private List<Product> products = new ArrayList<Product>
 // etc etc

public Inventory(String fileName) throws IOException {
      // Load file,
       // Read each product, 
       products.add(new Product(...product arguments); //add to array
  }

  public Product[] getProducts() {
      return products.toArray(new Product[]{});
  }