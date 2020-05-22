FileInputStream is = new FileInputStream("Books.ser");
ObjectInputStream ois = new ObjectInputStream(is);

for (int i = 1; i < 1000; i++) {
    Object o = os.readObject();
    // Do something with o - e.g. add to a List
}

ois.close();