class MassProduction {
    ProductFactory factory;
    public MyClass(ProductFactory fact) {
       factory = fac;
    }
    public List<Product> produce(int amount) {
        ArrayList<Product> result = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) { 
            result.add(factory.createProduct());
        }
        return result;
    }
}