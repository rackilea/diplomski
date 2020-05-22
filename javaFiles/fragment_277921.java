for(Image image:product.getImages())
   {
    image.setProduct(null);
    product.getImages().remove(image);
   }
productService.saveProduct(product);