class MyClient {

  @Autowired
  public MyClient(ProductRepository<Car> carRepository, 
                  ProductRepository<Wine> wineRepository) { … }
}