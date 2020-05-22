new BinderProxy(binder()) {
  @Override
  public <T> AnnotatedBindingBuilder<T> bind(Class<T> clazz) {
    if (clazz == EntityManager.class) {
      return (AnnotatedBindingBuilder<T>) super.bind(clazz).annotatedWith(DefaultEntityManager.class);
    } else {
      return super.bind(clazz);
    }
  }
}.install(new JpaPersistModule("myJpaUnit"));