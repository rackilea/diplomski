public class InheritedClassTest {
    @Test
    public void testDoStuff() throws Exception {
        final InheritedClass inheritedClass = Mockito.spy(new InheritedClass());

        Mockito.doReturn("mocked parent").when((ParentClass)inheritedClass).doStuff(Mockito.eq("do parent"));

        final String result = inheritedClass.doStuff("do parent");

        assertEquals("mocked parent", result);
        assertNotEquals("parent", result);

        final String resultChild = inheritedClass.doStuff("aaa");

        assertEquals("child", resultChild);
    }
}