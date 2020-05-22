import static java.lang.System.out;

public class Zeug {
    static String[] opts = new String[] { "java.version", "java.vendor",
            "java.vendor.url", "java.home", "java.vm.specification.version",
            "java.vm.specification.vendor", "java.vm.specification.name",
            "java.vm.version", "java.vm.vendor", "java.vm.name",
            "java.specification.version", "java.specification.vendor",
            "java.specification.name", "java.class.version", "java.class.path",
            "java.library.path", "java.io.tmpdir", "java.compiler",
            "java.ext.dirs", "os.name", "os.arch", "os.version",
            "file.separator", "path.separator", "line.separator", "user.name",
            "user.home", "user.dir" };

    public static void main(String[] args) {
        for(String o : opts) {
            out.println(o + ": " + System.getProperty(o));
        }
    }
}