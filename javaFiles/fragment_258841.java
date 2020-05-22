public class ReplaceInFile {

    private final static String src = "test.txt";
    private final static String dst_str = "test_new_str.txt";
    private final static String dst_prop = "test_new_prop.txt";

    public static void main(String[] args) throws IOException {
        usingStringOperations();
        usingProperties();
    }

    private static void usingProperties() throws IOException {
        File srcFile = new File(src);
        FileInputStream fis = new FileInputStream(srcFile);
        Properties properties = new Properties();
        properties.load(fis);
        fis.close();
        if(properties.getProperty("hostname") != null) {
            properties.setProperty("hostname", "127.0.0.1");
            FileOutputStream fos = new FileOutputStream(dst_prop);
            properties.store(fos, "Using java.util.Properties");
            fos.close();
        }
    }

    private static void usingStringOperations() throws IOException {
        File srcFile = new File(src);
        FileInputStream fis = new FileInputStream(srcFile);
        int len = fis.available();
        if(len > 0) {
            byte[] fileBytes = new byte[len];
            fis.read(fileBytes, 0, len);
            fis.close();
            String strContent = new String(fileBytes);
            int i = strContent.indexOf("localhost");
            if(i != -1) {
                String newStrContent = strContent.substring(0, i) + 
                        "127.0.0.1" +
                        strContent.substring(i + "localhost".length(), strContent.length());
                FileOutputStream fos = new FileOutputStream(dst_str);
                fos.write(newStrContent.getBytes());
                fos.close();    
            }
        }
    }
}