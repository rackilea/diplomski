public static void main(String[] args) throws IOException {
       f("first");
       f("second");
       f("third");
    }


private static void f(Object o) throws IOException {
        String Filename = "MoviesLinkedList.bin";
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(Filename, true));
        os.writeObject(0);
        os.close();
    }