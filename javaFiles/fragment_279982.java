public class EqualMethodsTest extends TestCase{
    @Test
    public void testEqual2() {
        assertEquals(1, new EqualMethods("goma").equal(new EqualMethods("goma")));
    }
}