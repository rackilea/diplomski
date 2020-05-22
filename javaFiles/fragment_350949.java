package xml_strings;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadingResourcesWithSax {

 static Map<String, String> mapaEn = new LinkedHashMap<String, String>();
 static Map<String, String> mapaPl = new LinkedHashMap<String, String>();

 public static void main(String[] args) throws Exception {
  XmlHandler xmlHandler = new XmlHandler();
  xmlHandler.setMap(mapaEn);
  SAXParserFactory factory = SAXParserFactory.newInstance();
  SAXParser saxParser = factory.newSAXParser(); 
  saxParser.parse("stringsEn.xml", xmlHandler);
  
  XmlHandler xmlHandler1 = new XmlHandler();
  xmlHandler1.setMap(mapaPl);
  SAXParserFactory factory1 = SAXParserFactory.newInstance();
  SAXParser saxParser1 = factory1.newSAXParser(); 
  saxParser1.parse("stringsPl.xml", xmlHandler1);


  for (String key : mapaEn.keySet()) {
   System.out.print(key + "\n");
   System.out.println("<" + mapaEn.get(key) + ">\n");
  }

  for (String key : mapaPl.keySet()) {
   System.out.print(key + "\n");
   System.out.println("<" + mapaPl.get(key) + ">\n");
  }
    List<Map<String, String>> listaMap = new ArrayList<Map<String, String>>();
    listaMap.add(mapaEn); 
    listaMap.add(mapaPl);
    
    Set<String> keySet = listaMap.get(0).keySet();
    for(String key: keySet)
    {
     System.out.println(key);
     for(Map<String, String> map: listaMap)
     {
      System.out.println("\t"+map.get(key));
     }
    }
    for(Map<String, String> lista : listaMap) {
     System.out.println("Wartosci dla tego samego klucza :  " + lista.get("type_not_saved"));
    }
 }

 private static class XmlHandler extends DefaultHandler {
  private Map<String, String> map;
  private boolean insideStringItem;
  private String a, b, c;
  private int i = 0;

  public void setMap(Map<String, String> map)
  {
   this.map = map;
  }
  
  public Map<String, String> getMap()
  {
   return map;
  }
  
  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes)
    throws SAXException {
   if (qName.equals("string")) {
    insideStringItem = true;
    a = attributes.getValue("name");
   }

   else if (qName.equals("string-array")) {
    insideStringItem = true;
    
    a = attributes.getValue("name");
    map.put(a,"string-array");
    c = a;
   } else if (qName.equals("item")) {
    insideStringItem = true;
    a = c + "###" + i;
    i++;
   }
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
   if (insideStringItem) {

    insideStringItem = false;
    b = new String(ch, start, length);
    map.put(a, b);
   }
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
   if (qName.equals("string-array")) {
    i = 0;
   }
  }
 }

}