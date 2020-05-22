/** Returns true if the passed object has FooBar anywhere in its class name. */
class HasFooBarInClassName extends ArgumentMatcher<Object> {
  @Override public boolean matches(Object object) {
    return object.getClass().getName().contains("FooBar");
  }
}

when(api.mockedMethod(argThat(new HasFooBarInClassName())).thenReturn(3L);