public void test_a() {
  ...

  doReturn("FakeB").when(restClient).getB("token"));
  assertNotNull(a.init("token"))
}