import java.io.File;
import java.net.URL;

class WhereIsMyGrandParent {
    public static void main(String[] args) throws Exception {
        File f = new File("WhereIsMyGrandParent.java");

        URL url = f.toURI().toURL();

        URL parent = new URL(url, "..");
        System.out.println("grand parent: " + parent);
    }
}