public class PropertyDemo {
    //private static InputStream in = PropertyDemo.class.getClassLoader().getResourceAsStream("address.properties");

    public void test() {
        InputStream in = null;
        try {
            in = PropertyDemo.class.getClassLoader().getResourceAsStream("address.properties");
            Properties pro = new Properties();
            pro.load(in);
            String address = pro.getProperty("returnInfoRegister");
            System.out.println(address);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {in.close();} catch (Exception e) {}
            }
        }

    }

    public static void main(String[] args) {
        new PropertyDemo().test();
        new PropertyDemo().test();
    }
}