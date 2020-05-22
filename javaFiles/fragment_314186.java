public class ProductsManager{
   private static ProductsManager productManager;
   private List<Product> productList;

   private ProductsManager(){
     this.productList = new ArrayList<>();
     //Or init your productList here
   }

   public static getInstance(){
     if(productManager == null){
       productManager = new ProductsManager();
     }
   }

   public List<Product> getProductsList(){
     return productList;
   }

   public Product getProduct(){
     //Some logic
   }

   public Product updateProductInfo(Product product){
     //Some logic
   }

   //Any other method to work with your products
}