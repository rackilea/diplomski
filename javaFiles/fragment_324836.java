import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.User32Util.MessageLoopThread;

public class HookTest {

    public interface Hook extends Library {
        Hook INSTANCE = (Hook) Native.loadLibrary("lib/Hook", Hook.class);
        public void FuncEndHook();
        public void FuncHookDevice();
    }

    public static void main(String[] args) {
        MessageLoopThread thread = new MessageLoopThread();
        thread.start();
        thread.runOnThread(() -> {
            Hook.INSTANCE.FuncHookDevice();
            return null;
        });
    }
}