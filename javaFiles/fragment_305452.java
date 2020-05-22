import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.lang3.StringUtils;

public class XmlApp {

  public static void main(String[] args) throws Exception {
    String testXML = "<Root>\n <a>Dummy Content</a>\n <b>\n </b>\n</Root>";

    XmlMapper xmlMapper = new XmlMapper();
    xmlMapper.setNodeFactory(new TrimStringTextJsonNodeFactory());

    JsonNode jsonNode = xmlMapper.readTree(testXML);

    System.out.println(jsonNode);
  }
}

class TrimStringTextJsonNodeFactory extends JsonNodeFactory {

  @Override
  public TextNode textNode(String text) {
    if (StringUtils.isBlank(text)) {
      text = StringUtils.trimToEmpty(text);
    }
    return super.textNode(text);
  }
}