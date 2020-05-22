import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
    JSONArray outerArray = new JSONArray("[{\"store_id\":\"81\",\"store_name\":\"Mayo - Castlebar McDrive\",\"store_type\":\"Drive-Thru\",\"vouchers_available\":\"Vouchers available\",\"store_limit\":\"10\",\"distance\":\"8123.33 km\",\"latitude\":\"53.8501090162671\",\"longitude\":\"-9.29713726043701\",\"image_name\":\"http:\\/\\/www.mcfinder.ie\\/admin\\/images\\/stores\\/default.png\",\"voucher_count\":\"2\",\"is_open\":\"Restaurant Open\",\"attributes\":[{\"attribute_name\":\"Wi-Fiiiii\",\"image_name\":\"http:\\/\\/www.mcfinder.ie\\/admin\\/images\\/attributes\\/t_wifi_icon.gif\"},{\"attribute_name\":\"Cashless\",\"image_name\":\"http:\\/\\/www.mcfinder.ie\\/admin\\/images\\/attributes\\/t_cashless_icon.gif\"},{\"attribute_name\":\"McDrive\",\"image_name\":\"http:\\/\\/www.mcfinder.ie\\/admin\\/images\\/attributes\\/car_icon.png\"}]}]");
    JSONObject object = outerArray.getJSONObject(0);
    JSONArray attributes = object.getJSONArray("attributes");
    for (int i = 0, length = attributes.length(); i < length; i++)
    {
      JSONObject attribute = attributes.getJSONObject(i);
      System.out.printf("attribute name=%s, image=%s\n", attribute.getString("attribute_name"), attribute.getString("image_name"));
    }
  }
}