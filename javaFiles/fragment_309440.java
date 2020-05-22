HttpSession session = request.getSession(true);
AtomicReference<ShoppingCart> cartRef;
// Ensure that the session is initialized
synchronized (lock) {
    cartRef = (<AtomicReference<ShoppingCart>)session.getAttribute("shoppingCart");
    if (cartRef == null) {
        cartRef = new AtomicReference<ShoppingCart>();
        session.setAttribute("shoppingCart", cartRef);
    }
}