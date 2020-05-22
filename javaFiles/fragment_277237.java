@XmlSchema(
    elementFormDefault=XmlNsForm.UNQUALIFIED,
    namespace="sample.url.something",
    xmlns={
        @XmlNs(prefix="Person", namespaceURI="sample.url.something")
    }
)
package com.example;

import javax.xml.bind.annotation.*;