static class MyObject implements Serializable{
    int i;
}

public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
    MyObject obj = new MyObject();
    obj.i = 77;
    File testFile = new File("test.dat");
    try (FileOutputStream fos = new FileOutputStream(testFile)) {
        fos.write(new byte[]{(byte) 0xFA, (byte) 0xCE, (byte) 0xAF, (byte) 0x0E});
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(obj);
        }
    }
    try (FileInputStream fis = new FileInputStream(testFile)) {
        byte b4[] = new byte[4];
        fis.read(b4);
        try (ObjectInputStream ois = new ObjectInputStream(fis)) {
           MyObject newObj = (MyObject) ois.readObject();
            System.out.println("newObj.i = " + newObj.i);
        }
    }
}