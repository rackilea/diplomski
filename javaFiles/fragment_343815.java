import java.security.Provider;
import java.security.Security;
import java.util.Enumeration;

/**
 *
 * @author alukasiewicz
 */
public class TestSignature {

   public static void print() throws Exception {
    try {
        Provider p[] = Security.getProviders();
      for (int i = 0; i < p.length; i++) {
          System.out.println(p[i]);
          for (Enumeration e = p[i].keys(); e.hasMoreElements();)
              System.out.println("\t" + e.nextElement());
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}