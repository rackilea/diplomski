import com.sun.jna.platform.win32.Kernel32;

public class JnaActiveCodePage {

    public static void main(String[] args) {
        System.out.println("" + JnaActiveCodePage.getActiveInputCodePage());
    }

    /**
     * Calls the Windows function GetConsoleCP() to get the active code page using JNA.
     * "jna.jar" and "jna-platform.jar" must be on the classpath.
     *
     * @return the code page number.
     */
    public static int getActiveInputCodePage() {
        return Kernel32.INSTANCE.GetConsoleCP();
    }
}