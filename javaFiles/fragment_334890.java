import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXDemo extends DefaultHandler {

  private Map<String, Location> postalCodeMap;

  static class Location {
    String latitude;

    String longitude;
  }

  public SAXDemo(List<String> postalCodes) {
    this.postalCodeMap = new HashMap<String, SAXDemo.Location>();
    for (String postalCodeToLookFor : postalCodes) {
      this.postalCodeMap.put(postalCodeToLookFor, new Location());
    }
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    String postCodeOfElem = attributes.getValue("postcode");
    if (postCodeOfElem != null && this.postalCodeMap.containsKey(postCodeOfElem)) {
      Location loc = this.postalCodeMap.get(postCodeOfElem);
      loc.latitude = attributes.getValue("latitude");
      loc.longitude = attributes.getValue("longitude");
    }
  }

  public Location getLocationForPostalCode(String postalCode) {
    return this.postalCodeMap.get(postalCode);
  }

  public Map<String, Location> getAllFoundGeoLocations() {
    return this.postalCodeMap;
  }
}