public void saveOrder(Order order) {
        Cart cart=order.getCart();
        order.setTotalPrice(cart.getGrandTotal());

        for (Map.Entry<Integer, CartItem> entry : cart.getCartItems().entrySet())
        {
            OrderDetails od = new OrderDetails();
            od.setOrder(order);

            Product product = entry.getValue().getProduct();
            od.setProduct(product);
            od.setQuantity(entry.getValue().getQuantity());
            od.setUnitPrice(product.getUnitPrice());
            orderDetailsRepository.save(od);
        }

        cartService.delete(order.getCart().getCartId());
    }
...

}