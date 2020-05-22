import static org.springframework.test.util.ReflectionTestUtils.*;

...

@Test
public void testUsingSpringReflectionTestUtils() {
    Foo foo = new Foo();
    setField(foo, "field", "Bar");
    assertEquals("Bar", foo.getField());
}