while (true) {
    ShoppingCart cart = cartRef.get();
    if (cart != null) {
        break;
    }
    cart = new ShoppingCart(...);
    if (cartRef.compareAndSet(null, cart))
        break;
}