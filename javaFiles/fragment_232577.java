JAXBContext context = // create the context with desired classes

Unmarshaller unmarshaller = context.createUnmarshaller();

unmarshaller.setListener(new Unmarshaller.Listener() {

  @Override
  public void afterUnmarshal(Object object, Object arg1) {
    System.out.println("unmarshalling finished on: " + object);

    Class<?> type = object.getClass();
    Method postConstructMethod = null;

    for (Method m : ReflectionUtils.getAllMethods(type)) {
      if (m.getAnnotation(PostConstruct.class) != null) {
        if (postConstructMethod != null) {
          throw new IllegalStateException(
              "@PostConstruct used multiple times");
        }

        postConstructMethod = m;
      }
    }

    if (postConstructMethod != null) {
      System.out.println("invoking post construct: "
          + postConstructMethod.getName() + "()");

      if (!Modifier.isFinal(postConstructMethod.getModifiers())) {
        throw new IllegalArgumentException("post construct method ["
            + postConstructMethod.getName() + "] must be final");
      }

      try {
        postConstructMethod.setAccessible(true); // thanks to skaffman
        postConstructMethod.invoke(object);
      } catch (IllegalAccessException ex) {
        throw new RuntimeException(ex);
      } catch (InvocationTargetException ex) {
        throw new RuntimeException(ex);
      }
    }
  }

});