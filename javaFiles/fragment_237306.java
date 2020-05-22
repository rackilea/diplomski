public static void main(String[] args) {
    try {
        FileInputStream file = new FileInputStream(new File("data.xml"));
        List<String> outs = Arrays.asList(new String[] { "hello = world", "abc = def" });
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = builderFactory.newDocumentBuilder();

        Document xmlDocument = builder.parse(file);

        XPath xPath = XPathFactory.newInstance().newXPath();

        System.out.println("*************************");
        String expression = "//clients/function/name[text()='data_values']";
        System.out.println(expression);
        Node nameTag = (Node) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODE);

        for (int i = 0; i < nameTag.getParentNode().getChildNodes().getLength(); i++) {
            if (nameTag.getParentNode().getChildNodes().item(i).getNodeName().equals("block")) {
                System.out.println("GOT BLOCK");
                nameTag.getParentNode().removeChild(nameTag.getParentNode().getChildNodes().item(i));
                Node node = xmlDocument.createElement("block");



                nameTag.getParentNode().appendChild(node);
                for (String out : outs) {
                    Node newNode = xmlDocument.createElement("opster");
                    newNode.setTextContent(out);

                    node.appendChild(newNode);
                }

            }
        }
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        DOMSource source = new DOMSource(xmlDocument);
        StreamResult result = new StreamResult(System.out);
        transformer.transform(source, result);

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (SAXException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ParserConfigurationException e) {
        e.printStackTrace();
    } catch (XPathExpressionException e) {
        e.printStackTrace();
    } catch (TransformerConfigurationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (TransformerException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}