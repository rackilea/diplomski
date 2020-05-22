@XmlSchema(
    namespace="http://www.example.eu/test",
    xmlns={
        @XmlNs(prefix="s", namespaceURI="http://www.example.eu/test")
    },
    elementFormDefault=XmlNsForm.QUALIFIED)
package forum17527941;

import javax.xml.bind.annotation.*;