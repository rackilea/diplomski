public class CompositeProduct` extends Product {
     private List<Product> products;

     public CompositeProduct(List<Product> products) { this.products = products }

     public String preview() {
          String previewText = "";
          for(Product product : products) { previewText+=product.preview(); }
          return preview;

     }
}