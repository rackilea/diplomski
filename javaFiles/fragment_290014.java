import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.Doclet;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.RootDoc;
import com.sun.tools.javadoc.Main;

public class DocletTest {

    public static void main(String[] args) {
        Main.execute("", Analyzer.class.getName(), new String[] {"path/to/your/file.java"});
    }

    public static class Analyzer extends Doclet {

        public static boolean start(RootDoc root) {
            for (ClassDoc classDoc : root.classes()) {
                System.out.println("Class: " + classDoc.qualifiedName());

                for (MethodDoc methodDoc : classDoc.methods()) {
                    System.out.println("  " + methodDoc.returnType() + " " + methodDoc.name() + methodDoc.signature());
                }
            }
            return false;
        }
    }
}