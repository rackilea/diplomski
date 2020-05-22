@Test
public void whenMappingAUuidThenItGetsCopiedByReference() {
    ClassWithUuid a = new ClassWithUuid();
    UUID uuid = UUID.randomUUID();
    a.setUuid(uuid);

    Mapper mapper = new Mapper();
    ClassWithUuid b = //map to b
    assertEquals(uuid, b.getUuid());
}

public static class ClassWithUuid {
    private UUID uuid;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}