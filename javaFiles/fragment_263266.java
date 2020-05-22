// [some code that is about to set the property on thirdLevelObject
Runnable deferredSetter = new Runnable() {
    public void run() {
         thirdLevelObject.setFoo(/* wherever the value for foo comes from later */);
    }
}