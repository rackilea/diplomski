import java.lang.Process;
import java.lang.Runtime;

// your code here
String keyPower = "input keyevent " + KeyEvent.KEYCODE_POWER;
Runtime runtime = Runtime.getRuntime();
Process proc = runtime.exec(keyPower);