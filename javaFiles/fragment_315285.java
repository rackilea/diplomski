import com.sun.jna.*;
import com.sun.jna.ptr.IntByReference;

public class jna_monitors_run {

    static final int MAX_DISPLAYS = 20;
    public static void main(String[] args) {
        IntByReference ib = new IntByReference();
        CoreGraphics.CGDirectDisplayID ids[] = new CoreGraphics.CGDirectDisplayID[MAX_DISPLAYS];
        if (! CoreGraphics.CGError.Success.equals(CoreGraphics.INSTANCE.CGGetActiveDisplayList(
                MAX_DISPLAYS, ids, ib))) {
            System.exit(2);
        }
        boolean is_asleep = true;
        int i = ib.getValue();
        while (--i >= 0) {
            is_asleep &= CoreGraphics.INSTANCE.CGDisplayIsAsleep(ids[i]);
        }
        System.out.println(is_asleep);
        System.exit(is_asleep ? 1 : 0);
    }
}