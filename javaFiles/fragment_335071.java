@Test
public void testBean() {

    MyClass object = new MyClass();
    // set object fields
    Mockito.when(dao.read(Matchers.eq(1))).thenReturn(object);

    assertThat(bean.someMethod(1)).isEqualTo(object);
}