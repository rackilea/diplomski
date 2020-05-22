public class CodeGenerator {

private final static String ENCODING = "UTF-8";
private final static String FILE_NAME = "File.txt";

public static void main(String[] args) {
    try {
        ArrayList<Carriage> names = getNames();
        for (Carriage c : names) {
            createSetter(c.name, c.capitalName);
            createGetter(c.name, c.capitalName);
        }
    } catch (FileNotFoundException ex) {
        ex.printStackTrace();
    }
}

private static ArrayList<Carriage> getNames() throws FileNotFoundException {
    File file = new File("/");
    InputStream is = CodeGenerator.class.getResourceAsStream(FILE_NAME);
    Scanner s = new java.util.Scanner(is, ENCODING).useDelimiter("\\A");
    String content = s.next();
    String[] lines = content.split(System.getProperty("line.separator"));
    ArrayList<Carriage> ret = new ArrayList<Carriage>();
    for (String line : lines) {
        line = line.replaceAll("\\r", "");
        int firstCapitalIndex = line.indexOf("String") + 7;
        int secondCapitalIndex = line.indexOf(" ", firstCapitalIndex);
        int firstIndex = line.indexOf("\"") + 1;
        int secondIndex = line.indexOf("\"", firstIndex + 1);
        Carriage c = new Carriage();
        c.name = line.substring(firstIndex, secondIndex);
        c.capitalName = line.substring(firstCapitalIndex, secondCapitalIndex);
        ret.add(c);
    }
    return ret;
}

public static void createSetter(String name, String capitalName) {
    String str = "public void set" + name + "(String val) {\n"
            + "\tset(" + capitalName + ", val);\n"
            + "}\n";
    System.out.println(str);
}

public static void createGetter(String name, String capitalName) {
    String str = "public String get" + name + "() {\n"
            + "\treturn (String) get(" + capitalName + ");\n"
            + "}\n";
    System.out.println(str);
}