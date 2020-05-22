@Inject
private IProductConfigurationService _productService;
@Persist
private MyGridDataSource _products;
. . . .
_products = new MyGridDataSource(productService.getProductConfigurations());