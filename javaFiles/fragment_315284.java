import com.sun.jna.*;
import com.sun.jna.ptr.IntByReference;

public interface CoreGraphics extends Library {
    CoreGraphics INSTANCE = (CoreGraphics)Native.loadLibrary("CoreGraphics", CoreGraphics.class);

    class int32_t extends IntegerType {
        public static final int SIZE = 4;
        public int32_t() {
            this(0);
        }
        public int32_t(long value) {
            super(SIZE, value, false);
        }
    };

    public static class CGError extends int32_t {
        public static final CGError Success = new CGError(0);

        public CGError() { this(0); }
        public CGError(int value) { super(value); }
    };

    public static class CGDirectDisplayID extends int32_t {
    };

    CGError CGGetActiveDisplayList(int maxDisplays, CGDirectDisplayID[] activeDisplays, IntByReference displayCount);
    boolean CGDisplayIsAsleep(CGDirectDisplayID disp);
}