public static class Tmp {
    public String f(Long a) {
        return a.toString();
    }
}

@Test
public void mockitoTest() {
    Tmp mock = Mockito.mock(Tmp.class);
    when(mock.f(AdditionalMatchers.not(Mockito.eq(5L)))).thenReturn("42");

    Assert.assertEquals("42", mock.f(4L));
    Assert.assertNull(mock.f(5L));
}