@Test
public void test() {
  CustomListAssert.assertThat(asList(0, 2, 3))
      .extractingInt(i -> i * 2)
      .allGreaterThan(0);
}