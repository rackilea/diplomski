Supplier<String> sup = () -> "test";
// your intention is that your list accepts the object referenced by sup
SomeOrdinaryClass obj = new SomeOrdinaryClass();
// but not that object referenced by obj... I supose
sup = obj;
// except when it is referenced by sup?