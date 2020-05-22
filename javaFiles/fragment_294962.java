import com.sun.jna.ptr.IntByReference;
import com.sun.jna.platform.win32.Secur32;

// ...    

char[] name = new char[100];  // or whatever is appropriate
Secur32.INSTANCE.GetUserNameEx(
     Secur32.EXTENDED_NAME_FORMAT.NameDisplay,
     name,
     new IntByReference(name.length)
);

String fullName = new String(name).trim();