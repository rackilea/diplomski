public class MyMainClass {

    public static void main(String[] args) throws Exception {
        InputStream inputStream = MyMainClass.class.getResourceAsStream(args[0]);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
    }
}