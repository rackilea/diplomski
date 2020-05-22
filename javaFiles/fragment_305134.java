import com.googlecode.javacpp.*;
import com.googlecode.javacpp.annotation.*;

@Platform(include="Driver.h",link="Driver")
public class Driver {
    static { Loader.load(); }
    public static native @Cast("BOOL") boolean IsInitialized();
    public static native int Initialize(int Slot);
    public static native int Finalize();
    public static native int FinalizeML(int nSlot);
}