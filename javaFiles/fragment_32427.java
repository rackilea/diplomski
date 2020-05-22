Stream.of(Material.class.getMethods())
      .filter(method -> method.getName().startsWith("get"))
      .map(getterMethod -> getterMethod.invoke(m))
      .forEach(fieldValue -> {
            //do something
      });