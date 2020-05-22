private void create() {
    Category catEtf = new Category();
    categoryRepo.save(catEtf);
    Stock s1 = new Stock();
    stockRepo.save(s1);
    Product bobEtfs = new Product();
    productRepo.save(bobEtfs);

    // create a relationship
    StockProduct bs1 = new StockProduct();
    bs1.setId(new StockProductPk());
    bs1.setProduct(bobEtfs);
    bs1.setStock(s1);
    bs1.setCategory(catEtf);
    stockProductRepo.save(bs1); 
}
private void read() {
    StockProduct sp1 = new StockProduct();
    Product p1 = new Product();
    p1.setId(1L);
    sp1.setProduct(p1);
    List<StockProduct> bobEtfs = stockProductRepo.findAll(Example.of(sp1, ExampleMatcher.matching()));
    System.out.println(bobEtfs);
}