public void testF() {
    int arg = 5;

    int result = new FunctionalTest().f(arg);

    assert result == arg * 5;
}