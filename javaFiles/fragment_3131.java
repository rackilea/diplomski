package cars;

import javax.xml.bind.*;
import java.io.File;
import java.util.*;

import javax.xml.stream.*;
import javax.xml.transform.stream.StreamSource;

public class Main {
  public static void main(String[] argv) throws Exception {
    List<Car> cars = new ArayList<Car>();

    JAXBContext ctx = JAXBContext.newInstance(Car.class, V12Engine.class, V6Engine.class, Brand.class);
    Unmarshaller um = ctx.createUnmarshaller();

    // create an adapter, and register it with the unmarshaller
    BrandAdapter ba = new BrandAdapter();
    um.setAdapter(BrandAdapter.class, ba);

    // create a StAX XMLStreamReader to read the XML file
    XMLInputFactory xif = XMLInputFactory.newFactory();
    XMLStreamReader xsr = xif.createXMLStreamReader(new StreamSource(new File("file.xml")));

    xsr.nextTag(); // root <list> element
    xsr.nextTag(); // first <brand> or <car> child

    // read each <brand>/<car> in turn
    while(xsr.getEventType() == XMLStreamConstants.START_ELEMENT) {
      Object obj = um.unmarshal(xsr);

      // unmarshal from an XMLStreamReader leaves the reader pointing at
      // the event *after* the closing tag of the element we read.  If there
      // was a text node between the closing tag of this element and the opening
      // tag of the next then we will need to skip it.
      if(xsr.getEventType() != XMLStreamConstants.START_ELEMENT && xsr.getEventType() != XMLStreamConstants.END_ELEMENT) xsr.nextTag();

      if(obj instanceof Brand) {
        // top-level <brand> - hand it to the BrandAdapter so it can be
        // cached if necessary
        ba.unmarshal((Brand)obj);
      }
      if(obj instanceof Car) {
        cars.add((Car)obj);
      }
    }
    xsr.close();

    // at this point, cars contains all the Car objects we found, with
    // any <brand> refIds resolved.
  }
}