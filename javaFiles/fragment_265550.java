public static class MyClass implements Serializable {
    private final String content;

    public MyClass(final String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

@Test
public void testWriteObject() throws IOException, ClassNotFoundException {
    MyClass nullInstance = null;
    MyClass notNullInstance = new MyClass("This content is not null");

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (ObjectOutputStream os = new ObjectOutputStream(baos)) {
        os.writeObject(nullInstance);
        os.writeObject(notNullInstance);
    }

    try (ObjectInputStream is = 
                 new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {

        MyClass shouldBeNull = (MyClass) is.readObject();
        MyClass shouldNotBeNull = (MyClass) is.readObject();

        Assert.assertNull(shouldBeNull);
        Assert.assertNotNull(shouldNotBeNull);

        // Attributes are serialized too
        Assert.assertEquals("This content is not null", shouldNotBeNull.getContent());
    }
}