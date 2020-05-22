public class TestApp {
    public static void main(String[] args) {
        java.net.URL url = junit.textui.TestRunner.class.getResource("/LICENSE-junit.txt");
        // print: jar:file:/C:/Users/XXXXX/.gradle/caches/modules-2/files-2.1/junit/junit/4.12/2973d150c0dc1fefe998f834810d68f278ea58ec/junit-4.12.jar!/LICENSE-junit.txt
        System.out.println(url);
        try {
            java.util.Scanner scanner = new java.util.Scanner(url.openStream()).useDelimiter("\n");
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}