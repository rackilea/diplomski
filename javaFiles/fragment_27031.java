/**
 *
 * @author David
 */
public class JavaApplication60 {
/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    //http://img.viralpatel.net/java-cup-logo.png

    //located in a package not in the current one
    URL url = new JavaApplication60().getResource("/javaapplication60/newpackage/java-cup-logo.png");
    System.out.println(url.getPath());
    //located in same package
    url = new JavaApplication60().getResource("/javaapplication60/java-cup-logo.png");
    System.out.println(url.getPath());
}

public InputStream getResourceAsStream(String name) {
    name = resolveName(name, this.getClass());
    ClassLoader cl = getClass().getClassLoader();
    if (cl == null) {
        return ClassLoader.getSystemResourceAsStream(name); // A system class.
    }
    return cl.getResourceAsStream(name);
}

public java.net.URL getResource(String name) {
    name = resolveName(name, this.getClass());
    ClassLoader cl = getClass().getClassLoader();
    if (cl == null) {
        return ClassLoader.getSystemResource(name);  // A system class.
    }
    return cl.getResource(name);
}


/*
 * The resolveName method adds a package name prefix if the name is not
 * absolute, and removes any leading "/" if the name is absolute. It is
 * possible, though uncommon, to have classes in diffent packages sharing
 * the same resource.
 */
private String resolveName(String name, Object clazz) {
    if (name == null) {
        return name;
    }
    if (!name.startsWith("/")) {
        Class c = clazz.getClass();
        while (c.isArray()) {
            c = c.getComponentType();
        }
        String baseName = c.getName();
        int index = baseName.lastIndexOf('.');
        if (index != -1) {
            name = baseName.substring(0, index).replace('.', '/') + "/" + name;
        }
    } else {
        name = name.substring(1);
    }
    return name;
}
}