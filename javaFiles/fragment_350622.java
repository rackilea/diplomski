map.merge("key", xMyObject, new BiFunction<MyObject, MyObject, MyObject>() {
    // this is the definition of what to do for two such values
    @Override
    public MyObject apply(MyObject myObject1, MyObject myObject2) {
        return new MyObject(myObject1.getVal() + myObject2.getVal());
    }
});