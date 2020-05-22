private Transformer transformer = null;

public String getPlaylist(String playlist) {
    if(transformer == null) {
        StreamSource xsl = new StreamSource(getClass().getResourceAsStream("M3Utransformation.xml"));
        try {
            transformer = TransformerFactory.newInstance().newTransformer(xsl);
        } catch (Throwable t) {
            t.printStackTrace();
            return null;
        }
    }
    StringWriter w = new StringWriter();
    Source source = new StreamSource(library);
    Result result = new StreamResult(w);
    try {
        transformer.setParameter("playlist", playlist);
        transformer.transform(source, result);
        return w.getBuffer().toString();
    } catch (Throwable t) {
        t.printStackTrace();
        return null;
    }
}