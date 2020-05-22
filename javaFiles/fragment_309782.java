public Data create() {
    for (DataFactory factory: ServiceLoader.load(DataFactory.class)) {
        if (factory.canCreate(this)) {
           Data result = factory.newInstance(this);
           result.loadData();
           return result;
        }
    }
    throw new IllegalStateException("not even the default instance supports this config");
}