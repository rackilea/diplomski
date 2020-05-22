C1<T> {
    private final Class<T> cls;

    C1(Class<T> pCls) {
      cls = pCls;
    }

    Class<?> getTypeParameter() {
      return cls;
    }
  }