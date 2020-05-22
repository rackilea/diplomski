@Test
public void test_foo() {
    ArgumentCaptor<RequestBuilder> reqCaptor = ArgumentCaptor.forClass(RequestBuilder.class);
    when(someotherclass.getLocationURI(any(RequestBuilder.class), anyString(), anyString())).thenReturn("locationURI");
    assertEquals("locationURI", Properties.getRequestBuilder("foo1"));
    verify(someotherclass).getLocationURI(reqCaptor.capture(), "foo1", "foo2");
    //Here you can check that reqCaptor.getValue() is equals to expected RequestBuilder and fail the test if not.
}