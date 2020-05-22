import java.io.IOException;
import java.io.StringReader;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;


public class FlattenXmlExample
{
  private static XMLInputFactory inFactory = XMLInputFactory.newInstance();

  public static void main(String[] args) throws XMLStreamException, IOException
  {

    String xmlRecord =
        "<emplist>\n" +
        "<emp>\n" +
        "   <manager>\n" +
        "   <id>1</id>\n" +
        "   <name>foo</name>\n" +
        "   </manager>\n" +
        "</emp>\n" +
        "<emp>\n" +
        "   <clerk>\n" +
        "   <cid>1</cid>\n" +
        "   <cname>foo</cname>\n" +
        "   </clerk>\n" +
        "</emp>\n" +
        " </emplist>";

    String flatXmlRecord = flattenXmlRecord(xmlRecord);

    System.out.print(flatXmlRecord);
  }

  private static String flattenXmlRecord(final String xmlRecord) throws XMLStreamException
  {
    StringBuilder flatXmlRecord = new StringBuilder();

    XMLEventReader eventReader = inFactory.createXMLEventReader(new StringReader(xmlRecord));

    while (eventReader.hasNext())
    {
      XMLEvent event = eventReader.nextEvent();

      if (event.getEventType() == XMLEvent.START_ELEMENT )
      {
        String elementName = event.asStartElement().getName().getLocalPart();


        event = eventReader.nextEvent();
        if(event.getEventType() == XMLEvent.CHARACTERS)
        {
          if(!event.asCharacters().getData().trim().isEmpty())
          {
            flatXmlRecord.append(elementName + ", " + event.asCharacters().getData() + "\n");
          }
        }
      }
    }

    return flatXmlRecord.toString();
  }
}