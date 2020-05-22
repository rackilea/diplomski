public class Test<T> {
  public static void main(String[] args) throws Exception {
    new Test<String>().test(String.class);
    new Test<Integer>().test(Integer.class);
    new Test<Long>().test(Long.class);
  }

  public void test(Class<T> cls) throws Exception {
    TypeToken<?> typeOfT = getGenToken(List.class, cls);
    List<?> lst = (List<?>) new Gson().fromJson("[1, 2, 3]", typeOfT.getType());

    for (Object o : lst) {
      System.out.println("value : " + o + ", type : " + o.getClass());
    }
  }

  static TypeToken<?> getGenToken(final Class<?> raw, final Class<?> gen) throws Exception {
    Constructor<ParameterizedTypeImpl> constr = ParameterizedTypeImpl.class.getDeclaredConstructor(Class.class, Type[].class, Type.class);
    constr.setAccessible(true);
    ParameterizedTypeImpl paramType = constr.newInstance(raw, new Type[] { gen }, null);

    return TypeToken.get(paramType);
  }
}