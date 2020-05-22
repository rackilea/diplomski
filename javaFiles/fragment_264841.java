private <V extends Type> void inst(Class<? extends AbstractToCreate<V>> clazz, Class<V> binding) {
    TypeToken<AbstractToCreate<V>> implementationType = new TypeToken<AbstractToCreate<V>>() {}
        .where(new TypeParameter<V>() {}, binding);
    TypeToken<Factory<V>> factoryType = new TypeToken<Factory<V>>() {}
        .where(new TypeParameter<V>() {}, binding);

    @SuppressWarnings("unchecked")  // The type returned by TypeToken::getType is always the type it represents
    Key<AbstractToCreate<V>> key = (Key<AbstractToCreate<V>>) Key.get(implementationType.getType());
    @SuppressWarnings("unchecked")  // as above
    Key<Factory<V>> factoryKey = (Key<Factory<V>>) Key.get(factoryType.getType());

    install(
        new FactoryModuleBuilder()
            .implement(key, clazz)
            .build(factoryKey));
  }