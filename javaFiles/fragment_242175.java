package blog.geocode;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name="kml")
@XmlType(propOrder={"country", "state", "city", "street", "postalCode"})
public class Address {

    @XmlPath("Response/Placemark/ns:AddressDetails/ns:Country/ns:AdministrativeArea/ns:SubAdministrativeArea/ns:Locality/ns:Thoroughfare/ns:ThoroughfareName/text()")
    private String street;

    @XmlPath("Response/Placemark/ns:AddressDetails/ns:Country/ns:AdministrativeArea/ns:SubAdministrativeArea/ns:Locality/ns:LocalityName/text()")
    private String city;

    @XmlPath("Response/Placemark/ns:AddressDetails/ns:Country/ns:AdministrativeArea/ns:AdministrativeAreaName/text()")
    private String state;

    @XmlPath("Response/Placemark/ns:AddressDetails/ns:Country/ns:CountryNameCode/text()")
    private String country;

    @XmlPath("Response/Placemark/ns:AddressDetails/ns:Country/ns:AdministrativeArea/ns:SubAdministrativeArea/ns:Locality/ns:PostalCode/ns:PostalCodeNumber/text()")
    private String postalCode;

}