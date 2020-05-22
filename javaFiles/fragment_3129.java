package cars;

import javax.xml.bind.annotation.adapters.*;
import java.util.*;

public class BrandAdapter extends XmlAdapter<Brand, String> {
  private Map<Integer, Brand> brandCache = new HashMap<Integer, Brand>();

  public Brand marshal(String s) {
    return null;
  }


  public String unmarshal(Brand b) {
    if(b.id != null) {
      // this is a <brand id="..."> - cache it
      brandCache.put(b.id, b);
    }
    if(b.refId != null) {
      // this is a <brand refId="..."> - pull it from the cache
      b = brandCache.get(b.refId);
    }

    // and extract the name
    return (b.name == null) ? null : b.name.trim();
  }
}