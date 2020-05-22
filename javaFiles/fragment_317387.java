private CallbackFilter callbackFilter = new CallbackFilter(){...};

...

private Type createType(ResultSet rst){
    String name = rst.getString(1);

    Enhancer enhancer = new Enchancer();
    enhancer.setSuperclass(Type.class);
    enhancer.setCallbackFilter(this.callbackFilter);
    enhancer.setCallbacks(new Callback[]{
        new LazyLoader(){...}
        new FixedValueImpl(name);
    });
    return (Type)enhancer.create()
}