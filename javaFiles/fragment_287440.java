public static final void newOutput(Document xml) throws Exception {
    Transformer tf = TransformerFactory.newInstance().newTransformer();
    tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    tf.setOutputProperty(OutputKeys.INDENT, "yes");
    DOMSource source = new DOMSource(xml);
    // Use StreamResult to write to a file to current directory
    StreamResult out = new StreamResult(new File("test.txt"));
    // to print to console
    // StreamResult out = new StreamResult(System.out);
    tf.transform(source, out);

    /*
     * console output is redirected to SRC folder to check format
     * need to update to write to folder
     */
    System.out.println(out.toString());

}