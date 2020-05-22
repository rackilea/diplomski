public class B {
    public String method2(Map<String, String> obj, String str3) {
        // this is irrelevant for our test of A
        return null;
    }
}

public class A {

    private Map<String, String> obj;
    private B b;

    public A(B b) {
        this.b = b;
    }

    /**
     * Replaces the internal obj map to a new Map containing str1 as key and str2 as value,
     * and calls b.method2() with that map and str3.
     * @return the value returned by b.method2()
     */
    public String method1(String str1, String str2, String str3) {
        obj = new HashMap<>();
        obj.put(str1, str2);
        String str = b.method2(obj, str3);
        return str;
    }

    public Map<String, String> getObj() {
        return obj;
    }
}

public class ATest {
    @Test
    public void method1ShouldCallMethod2WithCreatedMap() {
        B mockB = mock(B.class);

        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put("hello", "world");

        when(mockB.method2(expectedMap, "!")).thenReturn("ok");
        A a = new A(mockB);
        String result = a.method1("hello", "world", "!");
        assertEquals("ok", result);
        assertEquals(expectedMap, a.getObj());
    }

    // Same test, other technique
    @Test
    public void method1ShouldCallMethod2WithCreatedMap2() {
        B mockB = mock(B.class);


        when(mockB.method2(Mockito.<Map<String, String>>any(), anyString())).thenReturn("ok");
        A a = new A(mockB);
        String result = a.method1("hello", "world", "!");
        assertEquals("ok", result);

        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put("hello", "world");

        assertEquals(expectedMap, a.getObj());
        verify(mockB).method2(expectedMap, "!");
    }
}