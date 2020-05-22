private static String filename = "number.serialized";

    public static void main(String[] args) {
        Double d = 3.14;
        writeToBinary(d, filename);
        Double readD = readFromBinaryFile(filename);
        System.out.println(readD);
    }

    @SuppressWarnings ("unchecked")
    public static <T> T readFromBinaryFile(String filename) {
        T obj = null;
        File file = new File(filename);
        if (file.exists()) {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(filename));
                obj = (T)ois.readObject();
            } catch (IOException e) {
            } catch (ClassNotFoundException e) {
            } finally {
                try {
                    if (ois != null)
                        ois.close();
                } catch (IOException e) {
                }
            }
        }
        return obj;
    }

    public static <T> void writeToBinary(T obj, String filename) 
    {
        try {
            FileOutputStream fis = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fis);
            oos.writeObject(obj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }