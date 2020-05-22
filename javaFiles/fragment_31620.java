class MyItemProcessor<ProductCSV,Product> {
  public Product process(ProductCSV item) {
    Product p = new Product();

    p.setCategory(ProductCategory.fromDisplayName(item.getCategory());
  }
}