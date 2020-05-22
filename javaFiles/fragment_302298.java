public static void main(String[] args) 
{
    ShoppingCart cart = new ShoppingCart();
    Product orange = new Product();

    cart.addToCart(orange);

    try {
        cart.removeFromCart(orange);
    } catch (ProductException ex) { 
        /* 
           Do something... For example, displaying useful information via methods such 
           as ex.getMessage() and ex.getStackTrace() to the user, or Logging the error. 
         */
    } catch (Exception ex) { 
        // Do something...
    }
}