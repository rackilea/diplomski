static class Baz implements Serializable {
    private static final long   serialVersionUID    = 1L;
    int i;
    String s;
    public Baz(int i, String s) { this.i = i; this.s = s; }
}

@Test
public void serAL() throws FileNotFoundException, IOException, ClassNotFoundException {
    List<Baz> list = Arrays.asList(new Baz(1, "one"), new Baz(2, "two"), new Baz(3, "three"));
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("al.dat"))) {
        oos.writeObject(list);
    }
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("al.dat"))) {
        @SuppressWarnings("unchecked")
        List<Baz> serAL = (List<Baz>) ois.readObject();
        Assert.assertEquals(3, serAL.size());
        Assert.assertEquals(1, serAL.get(0).i);
        Assert.assertEquals("one", serAL.get(0).s);
        Assert.assertEquals(2, serAL.get(1).i);
        Assert.assertEquals("two", serAL.get(1).s);
        Assert.assertEquals(3, serAL.get(2).i);
        Assert.assertEquals("three", serAL.get(2).s);
    }
}