public class TestedClassTest {
    @Test
    public void testMethod() throws NoSuchFieldException, IllegalAccessException {
        Supplier<UUID> uuidSupplier = mock(Supplier.class);
        TestedClass testedClass = new TestedClass();
        Field uuidSupplierField = TestedClass.class.getDeclaredField("uuidSupplier");
        uuidSupplierField.setAccessible(true);
        uuidSupplierField.set(testedClass, uuidSupplier);

        String uuid = "5211e915-c3e2-4dcb-0776-c7b900f38ab7";
        when(uuidSupplier.get()).thenReturn(UUID.fromString(uuid));

        assertEquals(uuid, testedClass.getUuid());
    }
}