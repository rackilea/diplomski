public class ProductException extends RuntimeException 
{
    public ProductException(String message) 
    {
        super(message);
    }
}

public class ShoppingCart 
{
    public void removeFromCart(Product p) throws ProductException 
    { 
        int i = cart.indexOf(p);

        if (i >= 0) {
            cart.remove(p);
        } else {
            throw new ProductException("Error..Product not found");
        }
    }
}