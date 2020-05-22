class BusinessService {

    private FruitServices fruitServices;

    public <T extends Fruit> void compareVitamins(T one, T two) {

        @SuppressWarnings("unchecked")
        FruitCheckService<T> fruitCheckService = 
            (FruitCheckService<T>) fruitServices.getFruitCheckService(one.getClass());

        List<String> result = fruitCheckService.compareVitaminsFromDifferentCountries(one, two);
    }
}