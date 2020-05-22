@Service
public class ProductServiceImpl implements ProductService {

    private final Map<String, ProductHandler> productHandlersMap;

    @Autowired
    public ProductServiceImpl(Map<String, ProductHandler> productHandlersMap) {
        this.productHandlersMap = productHandlersMap;
    }

    @Override
    public ProductDetails calculateProductPrice(ProductType productType) {
        productHandlersMap.get(productType.beanName()).calculate();
        //..some otehr code goes here
        return productDetails;
    }
}