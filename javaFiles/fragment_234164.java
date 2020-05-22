<T extends A> A getA(Class<T> clazz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
  return clazz.getConstructor().newInstance();
}

//No generics needed here, since the method above returns A anyways.
//If it'd return T you'd have to change the return type here to B since getA(B.class) binds T to be B now
A getA() throws Exception {
  return getA(B.class); 
}