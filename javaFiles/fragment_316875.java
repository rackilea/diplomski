@Mapper
public interface ShoppingCartMapper{
    ShoppingCart map(Cart cart);
    ShoppingCartSample map(CartSample cartSample);

    @AfterMapping
    default void setShoppingCartSampleParent(@MappingTarget ShoppingCart cart){
        for(ShoppingCartSample cartSample : cart.getSamples()){
            cartSample.setShoppingCart(cart);
        }
    }
}