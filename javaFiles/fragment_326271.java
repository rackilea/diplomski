<!DOCTYPE jaxb:bindings [
<!ENTITY gh24type SYSTEM "gh24type.xml">
]>
<jaxb:bindings
    xmlns:jaxb="http://java.sun.com/xml/ns/jaxb"
    xmlns:xsd="http://www.w3.org/2001/XMLSchema"
    xmlns:annox="http://annox.dev.java.net"
    jaxb:extensionBindingPrefixes="annox"

    jaxb:version="2.1">

    <jaxb:bindings schemaLocation="schema.xsd" node="/xsd:schema">
        <!-- ... -->
        &gh24type;
    </jaxb:bindings>
</jaxb:bindings>