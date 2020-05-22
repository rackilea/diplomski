@PostMapping("/productes")
    public Product createProduct(@PathVariable(value = "categoryId") Long categoryId,
            @PathVariable(value = "supermarketId") Long supermarketId, @Valid @RequestBody Product product) {
        product.setCategory(categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + categoryId)));
        product.setSupermarket(supermarketRepository.findById(supermarketId)
                .orElseThrow(() -> new ResourceNotFoundException("Supermarket not found with id " + supermarketId)));
        return productRepository.save(product);
    }