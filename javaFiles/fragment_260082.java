class SomeClass implements Serializable {
    public transient final int a = 10;
    public transient final Integer b = 10;
    public transient final String c = "foo";

    public static void main(String[] args) throws Exception {

        SomeClass sc = new SomeClass();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(sc);

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(
                bos.toByteArray()));
        SomeClass sc2 = (SomeClass) ois.readObject();

        System.out.println(sc2.a);
        System.out.println(sc2.b);
        System.out.println(sc2.c);
    }
}