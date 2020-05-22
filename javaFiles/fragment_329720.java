import com.akash.mongo.multidb.entity.ProductDetails;

/**
 * Sample interface with one add method
 * @author Akash
 *
 */
public interface ProductDetailsService {

    /**
     * 
     * @param productOrigin - the shop name i.e. Amazon, Flipkart or ebay.
     * @param productDetails - the product details to add
     */
    public void addProductDetails(String productOrigin, ProductDetails productDetails) throws RuntimeException;

}