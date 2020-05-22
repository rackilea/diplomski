@PostMapping("/products")
public ResponseEntity<Object> createProduct(@Validated @RequestBody ProductForm productForm, BindingResult bindingResult) {
    //trying to make the code below work but I get an "incompatible type" error.

    if (bindingResult.hasErrors()) {
        List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
        // Here you can change ok to badRequest depending on your use case.
        return ResponseEntity.ok(new ErrorResponse("404", "Validation failure", errors));
        // In case if you want to fail the request, you need to use the below: 
        // return ResponseEntity.badRequest().body(new ErrorResponse("404", "Validation failure", errors));
    }

    Product product = productForm.convertToProduct();
    Product createdProduct = productRepository.save(product);
    return ResponseEntity.ok(new ProductResponse(createdProduct, "Product created"));
}