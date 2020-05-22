import com.googlecode.javacpp.*;
import com.googlecode.javacpp.annotation.*;

@Platform(include="lib.h", link="lib")
public class Lib {
    static { Loader.load(); }

    public static native int FunctionName(@Cast("uint32_t*") int[] arg1,
                                          @Cast("uint32_t*") int[] arg2,
                                          @Cast("uint32_t*") int[] arg3);
    public static void main(String[] args) {
        int[] arg1 = new int[SIZE1], arg2 = new int[SIZE2], arg3 = new int[SIZE3];
        int ret = FunctionName(arg1, arg2, arg3);
        // do what you need to do with the arguments
    }
}