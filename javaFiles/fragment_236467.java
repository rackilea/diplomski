public static class Library {
    public boolean foo() {
        return true;
    }

    public boolean foo(String s) {
        return true;
    }

    public boolean foo(Integer s) {
        return true;
    }

    public String x(){
        return "";
    }

    public void y(){
        return;
    }
}


public static class ResponseProvider {
    public boolean result;
}

@Test
public void testFoo1() {
    final ResponseProvider provider = new ResponseProvider();
    provider.result = false;
    Library lib = Mockito.mock(Library.class, new Answer<Object>() {
        @Override
        public Object answer(InvocationOnMock invocation) throws Throwable {
            if ((invocation.getMethod().getName().equals("foo"))) {
                provider.result = true;
                return true;
            }
            return invocation.callRealMethod();
        }
    });

    //lib.foo();
    //lib.x();
    //lib.y();
    assertTrue(provider.result);

}