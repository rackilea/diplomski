class Builder<SHAPE extends Shape> {

  public final SHAPE shape = build();

  @SuppressWarnings("unchecked")
  private SHAPE build() {
    try {
      ParameterizedType parent = 
             (ParameterizedType) getClass().getGenericSuperclass();   
      Class<?> arg = (Class<?>) parent.getActualTypeArguments()[0];
      return (SHAPE) arg.newInstance();
    } catch (ReflectiveOperationException e) {
      throw new RuntimeException(e);
    }
  }

  public SHAPE shape() { return shape; }
}