// built-in type adapters that cannot be overridden
factories.add(TypeAdapters.JSON_ELEMENT_FACTORY);
factories.add(ObjectTypeAdapter.FACTORY);

// user's type adapters
factories.addAll(typeAdapterFactories);