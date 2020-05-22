@Service
public ProductCrudService extends AbstractCrudService<Product, ProductModel>{

  @Autowired
  @Qualifier("productEntityModelQualifier")
  EntityModelMapper<Product, ProductModel> mapper;

  @Override
  protected EntityModelMapper<Product, ProductModel> getMapper(){return mapper;}

  public void someMethod(Product product){
    ProductModel model = getMapper().map(product);
  }

}