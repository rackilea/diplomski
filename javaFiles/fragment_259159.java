public class TestRead
{
  public static String filename = "sampleXML.xml";
  public static String outputfile = "output.xml";

  public static void main(String args[]) throws XMLStreamException, IOException
  {
    try
    {
      XMLEventReader reader = XMLInputFactory.newInstance().createXMLEventReader(new     java.io.FileInputStream(filename));
      XMLEventWriter writer = XMLOutputFactory.newInstance().createXMLEventWriter(new     FileWriter(outputfile));
      while (reader.hasNext())
      {
        XMLEvent event = reader.nextEvent();
        if (event.isStartElement())
        {
          if(event.asStartElement().getName().getLocalPart().equalsIgnoreCase("Title"))
          {
            writer.add(event);
            XMLEvent xmlEvent = reader.nextEvent();
            writer.add(xmlEvent);
          }
        }
        if (event.isEndElement())
        {
          if (event.asEndElement().getName().getLocalPart().equalsIgnoreCase("Title"))
          {
            writer.add(event);
          }
        }
      }
      writer.flush(); 
      writer.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}