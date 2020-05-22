private class X {
    public int a;
}

@Test
public void supplier_getter_test() throws NoSuchFieldException {
    X a = new X();
    a.a = 5;

    Supplier<Integer> sup = getter(a, int.class, X.class.getField("a"));

    assertEquals(5, sup.get().intValue());
}