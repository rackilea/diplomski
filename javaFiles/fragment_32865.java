import org.apache.bcel.Repository;
import org.apache.bcel.classfile.AnnotationEntry;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ClassGen;

JavaClass clazz = Repository.lookupClass("test.House");
ClassGen cg = new ClassGen(clazz);
Method m = findMethod(clazz, "close");
AnnotationEntry ae = m.getAnnotationEntries(); // process annotations here...
cg.removeMethod(m); // remove the method you want to remove
JavaClass modifiedClazz = cg.getJavaClass();
modifiedClazz.dump("./gen/test/House.class"); // save to a new file