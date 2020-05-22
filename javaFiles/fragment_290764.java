public class FooTest {
    @Test
    public void testConstructor() { 
        String expected = "Hello";
        Foo f = new Foo(expected);
        Assert.assertEquals(expected, f.getMessage());
    }

    @Test
    public void testAdd() {
        int expected = 5;
        Assert.assertEquals(expected, Foo.add(2, 3));
    }
}