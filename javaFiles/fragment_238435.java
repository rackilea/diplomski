import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;

public interface JNAApiInterface extends Library {
    JNAApiInterface INSTANCE = (JNAApiInterface) Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"), JNAApiInterface.class);
    Pointer __iob_func();

    int sizeOfFileStructure = Platform.is64Bit() ? 48 : 32;
    Pointer stdout = JNAApiInterface.INSTANCE.__iob_func().share(sizeOfFileStructure);

    void printf(String format, Object... args);
    int sprintf(byte[] buffer, String format, Object... args);
    int scanf(String format, Object... args);
    int fflush (Pointer stream);
    int puts(String format) ;
    int fprintf(Pointer stream, String format, Object...args) ;
    void setbuf(Pointer stream, String buffer) ;
}

import com.sun.jna.Memory;
import com.sun.jna.platform.win32.Kernel32;

public class JNABucket {
    public static void main(String args[]) {

        JNAApiInterface jnaLib = JNAApiInterface.INSTANCE;
        Kernel32 klib = Kernel32.INSTANCE;
        Memory userName = new Memory(256);

        jnaLib.setbuf(jnaLib.stdout, null);
        jnaLib.printf("Hello World");

        for (int i = 0; i < args.length; i++) {
            jnaLib.printf("\nArgument %d : %s", i, args[i]);
        }

        jnaLib.puts("\nPlease Enter Your Name:\n");

        jnaLib.scanf("%s", userName);
        jnaLib.printf("\nYour name is: %s", userName);

        jnaLib.fprintf(jnaLib.stdout, "\nThis is a Test");

    }
}