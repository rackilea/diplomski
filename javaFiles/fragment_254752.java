import com.sun.jna.Library;
  import com.sun.jna.Native;

  public class DllTest {
  public interface IDLL extends Library {
        IDLL INSTANCE = (simpleDLL) Native.loadLibrary("tttt", IDLL.class);

        int LireNoVersion(); // DWORD LireNoVersion();
    }

    public static void main(String[] args) {
        IDLL sdll = IDLL.INSTANCE;

        int nover = sdll.LireNoVersion();

        System.out.println("version = " + nover + "\n");

    }

}