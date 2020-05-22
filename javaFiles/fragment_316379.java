import java.io.StringReader
import javax.xml.transform.stream.StreamSource
import javax.xml.validation.{Schema, SchemaFactory}
import javax.xml.XMLConstants
import scala.xml.Elem

val schemaXml = <xsd:schema xmlns:xsd="http://www.w3.org/2001/XMLSchema">
                  <xsd:element name="foo"/>
                </xsd:schema>
val schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

implicit def toStreamSource(x:Elem) = new StreamSource(new StringReader(x.toString))

// Very possible, possibly still not any good:
val schema = schemaFactory.newSchema(schemaXml)