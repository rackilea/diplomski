ShoppingCart cart = cartRef.get();
if (cart == null) {
    cart = new ShoppingCart(...);
    session.setAttribute("shoppingCart",
         new AtomicReference<ShoppingCart>(cart));
}