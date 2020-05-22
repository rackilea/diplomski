import com.sun.jna.Library;
import com.sun.jna.Native;
public class Test {
    static    {
    System.setProperty("java.library.path", "/root/Desktop/Pragati/OSGI/JNA/JNAExample/JNASimpleExample/JNAApp/bin");
    System.out.println("java lib path : " + System.getProperty("java.library.path"));
    //System.loadLibrary("src");            
}

public interface Test1 extends Library
{
   // Loading Referenced Libraries first
 Add ADD_INSTANCE = (Add) Native.loadLibrary("Add", Test.class);


    Test1 INSTANCE = (Test1) Native.loadLibrary("Test1", Test1.class);
    int CallingLibFunction(int x, int y);
}
//CallingLibFunction
public static void main(String[] args) {

    Test1 lib = Test1.INSTANCE;
    System.out.println(lib.CallingLibFunction(10, 20));
}
}