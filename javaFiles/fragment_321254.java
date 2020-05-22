public class BarStackedData
{

   private static CategoryModel model;
   private static DefaultCustomCommerceCartService defaultCustomCommerceCartService;
   private static ProductService productService;

   public static CategoryModel getCategoryModel()
   {
        model = new DefaultCategoryModel();

        model.setValue(
        "Low Stock",
        "Puma T-Shirts",
        new Long(defaultCustomCommerceCartService.getCustomAvailableStockLevel(productService.getProductForCode("30023506"),
                null)));
        model.setValue(
        "Low Stock",
        "Socks",
        new Long(defaultCustomCommerceCartService.getCustomAvailableStockLevel(productService.getProductForCode("30023206"),
                null)));

      ....... more code .....

      return model;
   }

   // Getter Method
   public DefaultCustomCommerceCartService getDefaultCustomCommerceCartService()
   {
      return defaultCustomCommerceCartService;
   }

   // Setter Method
   public void setProductService(ProductService productService)
   {
      this.productService = productService;
   }

}