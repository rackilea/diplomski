import java.io.IOException;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.util.ClassPath;

public class BcelTest {
    public static void main(String[] args) throws IOException {
        String classPath=System.getProperty("java.class.path");
        // demonstrating with our own class path examplary for an arbitrary path String
        ClassPath cp=new ClassPath(classPath);
        ClassPath.ClassFile cf=cp.getClassFile(BcelTest.class.getName());
        ClassParser p=new ClassParser(cf.getInputStream(), cf.getPath());
        JavaClass jc = p.parse();
        System.out.println(jc);

        // or just using our own system path explicitly
        cf=ClassPath.SYSTEM_CLASS_PATH.getClassFile("java.lang.Object");
        p=new ClassParser(cf.getInputStream(), cf.getPath());
        jc = p.parse();
        System.out.println(jc);
    }
}