public class Main {
    private static FileNameMap fileNameMap = URLConnection.getFileNameMap();

    public static void main(String... str) {
        System.out.print(fileNameMap.getContentTypeFor("my_file.xml"));
    }

}