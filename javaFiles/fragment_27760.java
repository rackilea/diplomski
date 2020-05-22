public void addCartProduct(String cartId, long productId) {
    updateCartProducts(cartId, (productCartDto, productBasicDto) -> productCartDto.addProduct(productBasicDto));
}

public void removeCartProduct(String cartId, long productId) {
    updateCartProducts(cartId, (productCartDto, productBasicDto) -> productCartDto.removeProduct(productBasicDto));
}

private void updateCartProducts(String cartId, BiFunction<ProductCartDto, ProductBasicDto, ProductCartDto> processCart){
    //The code from show method
    ProductBasicDto productBasicDto = productRepository
            .findOptionalById(productId)
            .orElseThrow(() -> new NoResultException("Cannot find product ID: " + productId));

    productCartRepository.showCart(cartId)
            .map(processCartDto -> processCart.apply(processCartDto, productBasicDto))
            .map(productCartDto -> productCartRepository.updateCart(cartId, productCartDto))
            .orElseThrow(() -> new NoResultException("Cannot find cart ID: " + cartId));
}