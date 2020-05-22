import com.sun.btrace.AnyType;
import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;


@BTrace public class YourCalls {
    @OnMethod(clazz="pack.age.MyClass", method="myMethod1",
              location=@Location(value=Kind.CALL, clazz="/.*/", method="/.*/"))
    public static void o(AnyType[] args) { // all calls to methods
        printArray(args);
    }
}