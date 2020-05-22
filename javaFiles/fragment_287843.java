public class Main {
private static List<String> list = new ArrayList<String>();
private static List<String> name = new ArrayList<String>();

public static String getSubPackage(String packageName) {
    try {
        getClassNamesFromPackage(packageName);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (URISyntaxException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    packageName = packageName.replace("/", ".");
    packageName = packageName.substring(0, packageName.lastIndexOf('.'));
    return packageName;
}

public static List<String> getClassNamesFromPackage(String packageName)
        throws IOException, URISyntaxException {
    ClassLoader classLoader = Thread.currentThread()
            .getContextClassLoader();
    URL packageURL;

    packageName = packageName.replace(".", "/");

    packageURL = classLoader.getResource(packageName);
    if (packageURL == null)
        System.out.println(packageName);
    if (new URI(packageURL.toString()) == null)
        System.out.println(packageURL);
    URI uri = new URI(packageURL.toString());

    File folder = new File(uri.getPath());
    // won't work with path which contains blank (%20)
    // File folder = new File(packageURL.getFile());
    File[] content = folder.listFiles();
    // System.out.println(folder);
    String entryName;
    for (File actual : content) {
        entryName = actual.getName();
        if (entryName.contains(".class")) {
            // System.out.println(entryName);
            // System.out.println(entryName.substring(0,
            // entryName.lastIndexOf('.')));
            entryName = entryName.substring(0, entryName.lastIndexOf('.'));

            // System.out.println(actual.getName());

            name.add(packageName.replace("/", ".") + "." + entryName);
        } else {
            if (!(entryName.contains(".xml"))
                    && !(entryName.contains(".properties"))
                    && !(entryName.contains(".wsdl"))
                    && !(entryName.contains(".mine"))
                    && !(entryName.contains(".r15857"))
                    && !(entryName.contains(".r15939"))) {
                packageName = packageName.replace("/", ".");
                packageName = packageName + "." + entryName;
                packageName = getSubPackage(packageName);
            }
        }

    }

    return name;
}

public static void match(String name, String line) {

    String pattern = "(" + name + ".)([a-z][A-Z]\\w+)";
    // line = "private java.lang.String com.poc.Example.mName";
    // Create a Pattern object
    Pattern r = Pattern.compile(pattern);

    // Now create matcher object.
    Matcher m = r.matcher(line);
    if (m.find()) {
        /*
         * System.out.println("Found value: " + m.group(0) );
         * System.out.println("Found value: " + m.group(1) );
         * System.out.println("Found value: " + m.group(2) );
         */
        list.add(m.group(1) + m.group(2));
    }

}

public static void getFields(String className) {
    // Field fields[]=a.getClass().getDeclaredFields();
    Field fields[];
    try {
        fields = Class.forName(className).getDeclaredFields();
        for (Field f : fields) {
            // System.out.println(f.toString());
            match(className, f.toString());
        }
    } catch (SecurityException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (ExceptionInInitializerError e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (MissingResourceException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    // System.out.println(a.getClass().getName());

}

@SuppressWarnings("rawtypes")
public static void main(String[] args) throws Exception {
    // TODO Auto-generated method stub
    // Example a = new Example();
    // Example1 b = new Example1();

    // Class exmple = a.getClass().getDeclaredFields();
    String packageName = "com.oneassist";
    getClassNamesFromPackage(packageName);
    System.out.println(name.size());
    Iterator<String> iterator = name.iterator();
    System.out.println(name);
    String className = "";
    while (iterator.hasNext()) {
        className = iterator.next();
        // Class act = Class.forName(packageName+"."+className);
        // getFields(act);

        // System.out.println(className);
        /*
         * Class cls = Class.forName(className);
         * 
         * @SuppressWarnings("unchecked") Constructor ctor =
         * cls.getConstructor(); Object object = ctor.newInstance();
         */

        // System.out.println(className);
        getFields(className);

    }
    System.out.println(list);
    System.out.println("size =" + list.size());
}