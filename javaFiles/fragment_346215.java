package forum383861;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Unmarshaller.Listener;
import javax.xml.stream.Location;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Customer.class);


        XMLInputFactory xif = XMLInputFactory.newFactory();
        FileInputStream xml = new FileInputStream("src/forum383861/input.xml");
        XMLStreamReader xsr = xif.createXMLStreamReader(xml);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        LocationListener ll = new LocationListener(xsr);
        unmarshaller.setListener(ll);

        Customer customer = (Customer) unmarshaller.unmarshal(xsr);
        System.out.println(ll.getLocation(customer));
        System.out.println(ll.getLocation(customer.getAddress()));
    }

    private static class LocationListener extends Listener {

        private XMLStreamReader xsr;
        private Map<Object, Location> locations;

        public LocationListener(XMLStreamReader xsr) {
            this.xsr = xsr;
            this.locations = new HashMap<Object, Location>();
        }

        @Override
        public void beforeUnmarshal(Object target, Object parent) {
            locations.put(target, xsr.getLocation());
        }

        public Location getLocation(Object o) {
            return locations.get(o);
        }

    }

}