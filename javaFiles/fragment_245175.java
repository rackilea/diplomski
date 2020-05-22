import java.net.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.*;

final class Bindings {

  static final String SCHEME = "storage";
  static final Class<?>[] ALL_CLASSES = new Class<?>[]{
    Root.class, RawRef.class
  };

  static final class RawRepository
      extends XmlAdapter<URI, byte[]> {

    final SortedMap<String, byte[]> map = new TreeMap<>();
    final String host;
    private int lastID = 0;

    RawRepository(String host) {
      this.host = host;
    }

    @Override
    public byte[] unmarshal(URI o) {
      if (!SCHEME.equals(o.getScheme())) {
        throw new Error("scheme is: " + o.getScheme()
            + ", while expected was: " + SCHEME);
      } else if (!host.equals(o.getHost())) {
        throw new Error("host is: " + o.getHost()
            + ", while expected was: " + host);
      }

      String key = o.getPath();
      if (!map.containsKey(key)) {
        throw new Error("key not found: " + key);
      }

      byte[] ret = map.get(key);
      return Arrays.copyOf(ret, ret.length);
    }

    @Override
    public URI marshal(byte[] o) {
      ++lastID;
      String key = String.valueOf(lastID);
      map.put(key, Arrays.copyOf(o, o.length));

      try {
        return new URI(SCHEME, host, "/" + key, null);
      } catch (URISyntaxException ex) {
        throw new Error(ex);
      }
    }

  }

  @XmlRootElement
  @XmlType
  static final class Root {

    @XmlElement
    final List<RawRef> element = new LinkedList<>();
  }

  @XmlType
  static final class RawRef {

    @XmlJavaTypeAdapter(RawRepository.class)
    @XmlElement
    byte[] raw = null;
  }

}