public A example; //this is variable from you can get Class
private Class<Object> getChildsGenericClass() {
        return (Class)((ParameterizedType)
                 (this.getClass().getGenericSuperclass()))
                                      .getActualTypeArguments()[0];
    }