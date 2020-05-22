import java.io.File;

public class Test {

    public static void main(String[] args) {
        String name = Test.class.getName().replace(".", File.separator);
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + name.substring(0, name.lastIndexOf(File.separator));
        System.out.println(path);
    }

}