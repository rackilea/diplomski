@XmlSchema(
    namespace = "http://www.example.com/a",
    elementFormDefault = XmlNsForm.QUALIFIED,
    xmlns = {
        @XmlNs(prefix="ns1", namespaceURI="http://www.example.com/a")
    }
)  

package authenticator.beans.login;
import javax.xml.bind.annotation.*;