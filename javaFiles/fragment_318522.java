public class JaxbTest {
    @Test
    public void unmarshal() throws JAXBException, IOException {
        URL xmlUrl = Resources.getResource("json.txt");
        InputStream stream = Resources.newInputStreamSupplier(xmlUrl).getInput();
        Issue issue = parse(stream, Issue.class);

        assertEquals("summary", issue.getFields().getSummary().getName());

        Element element = issue.getFields().getFields().get(0);
        assertEquals("customfield_10080", element.getTagName());
        assertEquals("name", element.getFirstChild().getLocalName());
        assertEquals("Testeur", element.getFirstChild().getFirstChild().getTextContent());
    }

    private <T> T parse(InputStream stream, Class<T> clazz) throws JAXBException {
        JSONUnmarshaller unmarshaller = JsonContextNatural().createJSONUnmarshaller();
        return unmarshaller.unmarshalFromJSON(stream, clazz);
    }

    private JSONJAXBContext JsonContextNatural() throws JAXBException {
        return new JSONJAXBContext(JSONConfiguration.natural().build(), Issue.class);
    }
}