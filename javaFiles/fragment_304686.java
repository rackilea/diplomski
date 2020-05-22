import java.net.NetworkInterface;
import java.util.Enumeration;

public class NetworkInterfaceTest {

  public static void main(String args[]) {
    try {
      Enumeration<NetworkInterface> ie = NetworkInterface.getNetworkInterfaces();
      while (ie.hasMoreElements()) {
        NetworkInterface i = ie.nextElement();
        System.out.println(i.getDisplayName() + " [" + i.getName() + "]: " + formatAddress(i.getHardwareAddress()) + "; isVirtual=" + i.isVirtual());
      }
    } catch (Exception e){ 
      e.printStackTrace();
    }
  }

  private static String formatAddress(byte[] address) {
    if (address == null) {
      return null;
    }

    StringBuilder ret = new StringBuilder(address.length * 2);
    for (byte b : address) {
      if (ret.length() > 0) {
        ret.append('-');
      }

      String bs = Integer.toHexString(b & 0x000000FF).toUpperCase();
      if (bs.length() < 2) {
        ret.append('0');
      }
      ret.append(bs);
    }

    return ret.toString();
  }

}