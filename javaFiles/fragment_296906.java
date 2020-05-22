@XmlSchema(
    namespace="urn:sobject.enterprise.soap.sforce.com", 
    elementFormDefault=XmlNsForm.QUALIFIED,
    xmlns={
        @XmlNs(prefix="out", namespaceURI = "http://soap.sforce.com/2005/09/outbound"),
        @XmlNs(prefix="sf", namespaceURI = "urn:sobject.enterprise.soap.sforce.com"),
    })
package forum987537;

import javax.xml.bind.annotation.*;