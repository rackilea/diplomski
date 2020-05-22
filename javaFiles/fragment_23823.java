/**
 * Create a DOM document from a DOM4J document 
 */
static Document copy(org.dom4j.Document orig) {
    try {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        DOMResult result = new DOMResult();
        t.transform(new DocumentSource(orig), result);
        return (Document) result.getNode();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}