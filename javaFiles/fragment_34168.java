import java.io.File;
import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
    ObjectMapper mapper = new ObjectMapper();
    Store[] stores = mapper.readValue(new File("input.json"), Store[].class);
    Store store = stores[0];
    List<Attribute> attributes = store.attributes;
    for (Attribute attribute : attributes)
    {
      System.out.printf("attribute name=%s, image=%s\n", attribute.attribute_name, attribute.image_name);
    }
    // output:
    // attribute name=Wi-Fiiiii, image=http://www.mcfinder.ie/admin/images/attributes/t_wifi_icon.gif
    // attribute name=Cashless, image=http://www.mcfinder.ie/admin/images/attributes/t_cashless_icon.gif
    // attribute name=McDrive, image=http://www.mcfinder.ie/admin/images/attributes/car_icon.png
  }
}

class Store
{
  public String store_id;
  public String store_name;
  public String store_type;
  public String vouchers_available;
  public String store_limit;
  public String distance;
  public BigDecimal latitude;
  public BigDecimal longitude;
  public URI image_name;
  public int voucher_count;
  public String is_open;
  public List<Attribute> attributes;
}

class Attribute
{
  public String attribute_name;
  public URI image_name;
}