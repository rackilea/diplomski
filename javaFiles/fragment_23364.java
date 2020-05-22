@Path("dom")
public class DomXmlResource {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public StreamingOutput getXml() throws Exception {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("company");
        doc.appendChild(rootElement);

        Element staff = doc.createElement("Staff");
        rootElement.appendChild(staff);

        staff.setAttribute("id", "1");

        Element firstname = doc.createElement("firstname");
        firstname.appendChild(doc.createTextNode("yong"));
        staff.appendChild(firstname);

        return new StreamingOutput() {
            @Override
            public void write(OutputStream out)
                    throws IOException, WebApplicationException {
                try {
                    Transformer transformer = TransformerFactory.newInstance()
                            .newTransformer();
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    StreamResult result = new StreamResult(out);
                    DOMSource source = new DOMSource(doc);
                    transformer.transform(source, result);
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}