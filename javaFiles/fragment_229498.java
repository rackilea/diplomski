import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.jni.JNINativeInterface;

class JavaObject {
    String message;

    JavaObject(String message) {
        this.message = message
    }
}

final long pointer = JNINativeInterface.NewGlobalRef(new JavaObject("Hello"));
JavaObject object = MemoryUtil.memGlobalRefToObject(pointer);
JNINativeInterface.DeleteGlobalRef(pointer);

System.out.println(object.message) // => "Hello"

// Already deleted the strong reference held by the native part of the application.
object = MemoryUtil.memGlobalRefToObject(pointer);
System.out.println(object) // => null