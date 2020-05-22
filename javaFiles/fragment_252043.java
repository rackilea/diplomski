try {
    Item.class.getConstructor(constructorArgs).newInstance(FirstObject, SecondObject);
} catch (NoSuchMethodException e) {
  // log the error
  e.printStackTrace();
}