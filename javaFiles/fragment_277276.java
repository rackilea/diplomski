public class SerializeJavaDemo {
    // Just to generate some random strings
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static SecureRandom rnd = new SecureRandom();

    public static void main(String[] args) {
        SerializeJavaDemo sd = new SerializeJavaDemo();
        String prefix = "test";
        String suffix = "temp";
        File directory = new File("serialize");

        // Serialize and then read    
        try {
            File file = File.createTempFile(prefix, suffix, directory);

            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream output = new ObjectOutputStream(fos);
            List<TestClass> list = sd.createListOfTestClasses();

            for (TestClass test : list) {
                output.writeObject(test);
            }

            output.close();
            fos.close();

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = null;

            int count = 0;
            while (true) {
                try {
                    obj = ois.readObject();
                    if (obj == null) {
                        break;
                    }
                    if (obj instanceof TestClass) {
                        count++;
                        System.out.println(count + "." + ((TestClass) obj).toString());
                    }
                } catch (Exception e) {
                    break;
                }
            }
            ois.close();
            fis.close();
            file.deleteOnExit();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<TestClass> createListOfTestClasses() {
        List<TestClass> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            String name = randomString(10);
            Random r = new Random();
            Integer id = r.nextInt();
            TestClass test = new TestClass(id, name);
            list.add(test);
        }
        return list;
    }

    private String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
}