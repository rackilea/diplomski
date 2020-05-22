public class Main {

public static void main(String[] args) throws InterruptedException {

    Map<String, String> tree = new HashMap<String, String>();
    tree.put("Klebebänder", "Hilfsstoffe und Beschichtungsstoffe");
    tree.put("Lacke", "Hilfsstoffe und Beschichtungsstoffe");
    tree.put("Pulver", "Hilfsstoffe und Beschichtungsstoffe");

    String k = get_Klassifizierung(tree);

    System.out.println(k);

    }

public static String get_Klassifizierung(Map<String, String> tree) throws InterruptedException {
    MyFrame m = new MyFrame(tree);
    while (m.myReturnValue == null) {
        Thread.sleep(1000);
    }

    m.dispose();
    return m.myReturnValue;
    }

}