import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;    
private String serializeItem(Object obj) {
    JSON jsonObject = JSONSerializer.toJSON(obj);
    XMLSerializer xmlSerializer = new XMLSerializer();
    xmlSerializer.setTypeHintsEnabled(true);
    return xmlSerializer.write(json);
}