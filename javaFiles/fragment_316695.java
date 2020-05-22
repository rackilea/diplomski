class FruitServices {

  private Map<Class<? extends Fruit>, FruitCheckService<? extends Fruit>> beansMap;


  public FruitServices(List<FruitCheckService<? extends Fruit>> fruitCheckServices) {

    beansMap = new HashMap<>();

    fruitCheckServices
      .forEach(
        fruitCheckService -> {
          Class<? extends Fruit> implementation = fruitCheckService.getImplementation();
          beansMap.put(implementation, fruitCheckService);
        }
      );
  }

  public FruitCheckService<? extends Fruit> getFruitCheckService(Class<? extends Fruit> clazz) {
    return beansMap.get(clazz);
  }
}