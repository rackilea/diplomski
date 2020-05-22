@Bean
public Map<Class, TFHService> serviceMap()
{
    Map<Class, TFHService> serviceMap = new HashMap<>();

    serviceMap.put(Bill.class, billService);
    serviceMap.put(Category.class, categoryService);
    serviceMap.put(Customer.class, customerService);
    serviceMap.put(Parameter.class, parameterService);
    serviceMap.put(Product.class, productService);
    serviceMap.put(Sequence.class, sequenceService);
    serviceMap.put(Supplier.class, supplierService);

    return serviceMap;
}