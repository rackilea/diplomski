public class XmlTest {

@Test
public void testXml() throws Exception {

    String xml = "<document>" +
            "  <properties>" +
            "    <basic>" +
            "      <property id=\"generationDate\">" +
            "        <value>20150525</value>" +
            "      </property>\n" +
            "      <property id=\"hostAddress\">" +
            "        <value>192.168.0.250</value>" +
            "        </property>" +
            "    </basic>" +
            "  </properties>" +
            "</document>";

    try {
        JAXBContext jaxbContext = JAXBContext.newInstance(PDFDocument.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        PDFDocument document = (PDFDocument) jaxbUnmarshaller.unmarshal(new ByteArrayInputStream(xml.getBytes()));


        System.out.println("PDF Document Structure -" +document.toString());


        for(Property property : document.getDocumentProperty().getBasic().getPropertyList()) {
            if(property.getId().equals("generationDate")){
                System.out.println("Generation Date : "+property.getValue());
            }
        }
    } catch (JAXBException ex) {
        ex.printStackTrace();
    }
}
}