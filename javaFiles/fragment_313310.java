public static String diffHtml(String first, String second) throws TransformerConfigurationException, IOException, SAXException {

    StringWriter finalResult = new StringWriter();
    SAXTransformerFactory tf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();

    TransformerHandler result = tf.newTransformerHandler();
    result.getTransformer().setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    result.getTransformer().setOutputProperty(OutputKeys.INDENT, "yes");
    result.getTransformer().setOutputProperty(OutputKeys.METHOD, "html");
    result.getTransformer().setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    result.setResult(new StreamResult(finalResult));

    ContentHandler postProcess = result;

    Locale locale = Locale.getDefault();
    String prefix = "diff";

    NekoHtmlParser cleaner = new NekoHtmlParser();

    InputSource oldSource = new InputSource(new StringReader(first));
    InputSource newSource = new InputSource(new StringReader(second));

    DomTreeBuilder oldHandler = new DomTreeBuilder();
    cleaner.parse(oldSource, oldHandler);
    TextNodeComparator leftComparator = new TextNodeComparator(oldHandler, locale);

    DomTreeBuilder newHandler = new DomTreeBuilder();
    cleaner.parse(newSource, newHandler);
    TextNodeComparator rightComparator = new TextNodeComparator(newHandler, locale);

    HtmlSaxDiffOutput output = new HtmlSaxDiffOutput(postProcess, prefix);

    HTMLDiffer differ = new HTMLDiffer(output);
    differ.diff(leftComparator, rightComparator);

    System.out.println(finalResult.toString());

    return finalResult.toString();
}