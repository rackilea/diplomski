ProductEntity productEntity=productMapper.dtoToEntity(productDto);
for(CategoryDto categoryDto:productDto.getCategories()){
    CategoryEntity categoryEntity=categoryMapper.dtoToEntity(categoryDto);
    productEntity.addCategory(categoryEntity); //changed line
   }
productEntity=productService.saveProduct(productEntity);
productDto.setProductId(productEntity.getProductId());