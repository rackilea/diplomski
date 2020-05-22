// define the type you want
TypeLiteral<Foo<Bar>> typeLiteral = new TypeLiteral<Foo<Bar>>() {};

// now search for beans; note that getBeans allows to specify Annotations as well!
Set<Bean<?>> beans = beanManager.getBeans(typeLiteral.getType());

// and apply resolution - you should get the one you want here
Bean<?> bean = beanManager.resolve(beans);