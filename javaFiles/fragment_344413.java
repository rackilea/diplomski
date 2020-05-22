XMLStreamReader reader = null;
try {
    URL url = new URL("http://hsv-artifactory.emrsn.org:8081/artifactory/libs-release-local/com/avocent/commonplatform/cps/symbols/MasterData/maven-metadata.xml");
    reader = XMLInputFactory.newInstance().createXMLStreamReader(url.openStream());
    String latest;
    while (reader.hasNext()) {
        if (reader.next() == XMLStreamConstants.START_ELEMENT) {
            if (reader.getLocalName().equals("latest")) {
                latest = reader.getElementText();
                break;
            }
        }
    }
} catch (IOException ex) {
    // handle exception
} catch (XMLStreamException ex) {
    // handle exception
} finally {
    // close the stream
}