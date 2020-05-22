public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<MyObject> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(new MyObject("key-" + i, "value-" + i, i));
        }

        for (int i = 0; i < 10; i++) {
            timeJavaSerialization(list);
            timeCustomSerialization(list);
            timeCustomSerialization2(list);
        }
    }

    private static void timeJavaSerialization(List<MyObject> list) throws IOException, ClassNotFoundException {
        File file = File.createTempFile("java-serialization", "dz");
        long start = System.nanoTime();
        ObjectOutputStream oos = new ObjectOutputStream(
                new DeflaterOutputStream(new FileOutputStream(file)));
        oos.writeObject(list);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(
                new InflaterInputStream(new FileInputStream(file)));
        Object o = ois.readObject();
        ois.close();
        long time = System.nanoTime() - start;
        long size = file.length();
        System.out.printf("Java serialization uses %,d bytes and too %.3f seconds.%n",
                size, time / 1e9);
    }

    private static void timeCustomSerialization(List<MyObject> list) throws IOException {
        File file = File.createTempFile("custom-serialization", "dz");
        long start = System.nanoTime();
        MyObject.writeList(file, list);
        Object o = MyObject.readList(file);
        long time = System.nanoTime() - start;
        long size = file.length();
        System.out.printf("Faster Custom serialization uses %,d bytes and too %.3f seconds.%n",
                size, time / 1e9);
    }

    private static void timeCustomSerialization2(List<MyObject> list) throws IOException {
        File file = File.createTempFile("custom2-serialization", "dz");
        long start = System.nanoTime();
        {
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
                    new DeflaterOutputStream(new FileOutputStream(file))));
            dos.writeInt(list.size());
            for (MyObject mo : list) {
                dos.writeUTF(mo.key);
            }
            for (MyObject mo : list) {
                dos.writeUTF(mo.val);
            }
            for (MyObject mo : list) {
                dos.writeInt(mo.num);
            }
            dos.close();
        }
        {
            DataInputStream dis = new DataInputStream(new BufferedInputStream(
                    new InflaterInputStream(new FileInputStream(file))));
            int len = dis.readInt();
            String[] keys = new String[len];
            String[] vals = new String[len];
            List<MyObject> list2 = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                keys[i] = dis.readUTF();
            }
            for (int i = 0; i < len; i++) {
                vals[i] = dis.readUTF();
            }
            for (int i = 0; i < len; i++) {
                list2.add(new MyObject(keys[i], vals[i], dis.readInt()));
            }
            dis.close();
        }
        long time = System.nanoTime() - start;
        long size = file.length();
        System.out.printf("Compact Custom serialization uses %,d bytes and too %.3f seconds.%n",
                size, time / 1e9);
    }


    static class MyObject implements Serializable {
        private String key;
        private String val;
        private int num;

        MyObject(String a, String b, int c) {
            this.key = a;
            this.val = b;
            this.num = c;
        }

        MyObject(DataInput in) throws IOException {
            key = in.readUTF();
            val = in.readUTF();
            num = in.readInt();
        }

        public void writeTo(DataOutput out) throws IOException {
            out.writeUTF(key);
            out.writeUTF(val);
            out.writeInt(num);
        }

        public static void writeList(File file, List<MyObject> list) throws IOException {
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(
                    new DeflaterOutputStream(new FileOutputStream(file))));
            dos.writeInt(list.size());
            for (MyObject mo : list) {
                mo.writeTo(dos);
            }
            dos.close();
        }

        public static List<MyObject> readList(File file) throws IOException {
            DataInputStream dis = new DataInputStream(new BufferedInputStream(
                    new InflaterInputStream(new FileInputStream(file))));
            int len = dis.readInt();
            List<MyObject> list = new ArrayList<>(len);
            for (int i = 0; i < len; i++) {
                list.add(new MyObject(dis));
            }
            dis.close();
            return list;
        }
    }
}