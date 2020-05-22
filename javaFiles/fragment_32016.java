public Product findProductBetweenPriceRange(int price1, int price2) {
   Optional<Product> product = productService.findProductBetween(price1, price2);
   return product.orElseThrow(() -> throwBadRequestException(price1, price2));
}

private BadRequestException throwBadRequestException(int price1, int price2) {
   String debugInfo = "price1="+price1+";price2="+price2;
   return new BadRequestException("No Product found for price range", debugInfo);
}