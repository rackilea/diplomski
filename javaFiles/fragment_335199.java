@Test
public void defaultInterfaceMethodTest() {
    Class<? extends Super> loaded = new ByteBuddy()
            .subclass(Super.class)
            .implement(Bar.class).make()
            .load(this.getClass().getClassLoader()).getLoaded();
    Bar newInstance = (Bar) loaded.getConstructor().newInstance();
    int shouldBeTwo = newInstance.returnSomethingMore();
    Assert.assertEquals(2, shouldBeTwo);
}