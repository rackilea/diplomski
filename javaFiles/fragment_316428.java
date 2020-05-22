@Test
public void getFieldTest() {
    class StupidObject { Object stupidField; }
    class ReallyStupidObject extends StupidObject { Object reallyStupidField; }

    // test the right field is found in the right class
    testFieldFind("stupidField", ReallyStupidObject.class,
            StupidObject.class);
    testFieldFind("reallyStupidField", ReallyStupidObject.class,
            ReallyStupidObject.class);

    // check that non-existent fields return null
    assertNull(FSUtils.getField(ReallyStupidObject.class, "fooballs"));
}

private static void testFieldFind(String fieldName, Class<?> classToSearch,
        Class<?> expectedDeclaringClass) {
    Field field = FSUtils.getField(classToSearch, fieldName);
    assertEquals(fieldName, field.getName());
    assertEquals(expectedDeclaringClass, field.getDeclaringClass());
}