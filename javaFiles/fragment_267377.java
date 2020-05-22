public static void main(String[] args) throws Exception {

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true);
    Document doc = null;
    NodeList nodes = null;
    Set<String> ids = null;
    try {
        doc = factory.newDocumentBuilder().parse(new File("d:/a.xml"));

        XPathExpression expr = XPathFactory.newInstance().newXPath().compile("//@siteKey");
        ids = new HashSet<String>();
        nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
    } catch (SAXException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ParserConfigurationException e) {
        e.printStackTrace();
    } catch (XPathExpressionException e) {
        e.printStackTrace();
    }

    for (int i = 0; i < nodes.getLength(); i++) {
        String id = nodes.item(i).getNodeValue();
        if (id.equals("siteKey")) {
            Element el = ((Attr) nodes.item(i)).getOwnerElement();
            el.removeAttribute(id);
        }
    }

    int dupes = 0;
    for (int i = 0; i < nodes.getLength(); i++) {
        String id = nodes.item(i).getNodeValue();
        if (ids.contains(id)) {
            System.out.format("%s is duplicate\n\n", id);
            dupes++;
        } else {
            ids.add(id);
        }
    }

    System.out.format("Total ids = %d\n Total Duplicates = %d\n", ids.size(), dupes);

    Transformer transformer;
    StreamResult result = null;
    try {
        transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        result = new StreamResult(new StringWriter());
        DOMSource source = new DOMSource(doc);
        transformer.transform(source, result);
    } catch (TransformerConfigurationException e) {
        e.printStackTrace();
    } catch (TransformerFactoryConfigurationError e) {
        e.printStackTrace();
    } catch (TransformerException e) {
        e.printStackTrace();
    }

    String xmlString = result.getWriter().toString();
    System.out.println(xmlString);

}