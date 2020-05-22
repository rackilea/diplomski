@Test
public void testAgingConstructor() {
    class AgingSubclass extends Aging {
        public AgingSubclass(int age) { super(age); }
    }
    Aging a = new AgingSubclass(18);
    a.setAge(19);
    Aging b = new AgingSubclass(19);
    assertEquals(b, a);
}