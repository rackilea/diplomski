<jaxws:bindings wsdlLocation="wsdl/TestImpl.wsdl" 
        xmlns:jaxws="http://java.sun.com/xml/ns/jaxws" 
        xmlns:xs="http://www.w3.org/2001/XMLSchema"
        xmlns:jaxb="http://java.sun.com/xml/ns/jaxb"
        xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
        jaxb:version="2.1">
  <jaxws:bindings node="wsdl:definitions/wsdl:types/xs:schema[@targetNamespace='http://namespace.goes.here']">
        <jaxb:bindings node="//xs:complexType[@name='testTO']//xs:element[@name='elements']">
            <jaxb:property>
                <jaxb:baseType name="java.util.Map&lt;String,Object&gt;" />
            </jaxb:property>
        </jaxb:bindings>
        <jaxb:serializable/>
  </jaxws:bindings>
</jaxws:bindings>