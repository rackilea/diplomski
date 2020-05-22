try {

    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

    Document document = null;
    File scores = new File("scores.xml");
    if (scores.exists()) {

        document = documentBuilder.parse("scores.xml");

    } else {

        document = documentBuilder.newDocument();
        document.appendChild(document.createElement("scores"));

    }

    Element rootElement = document.getDocumentElement();

    String name = "Kobe";
    double money = 11000000;

    Element player = document.createElement("player");
    Element playerName = document.createElement("name");
    playerName.setTextContent(name);
    Element moneyAmount = document.createElement("money");
    moneyAmount.setTextContent(NumberFormat.getNumberInstance().format(money));

    player.appendChild(playerName);
    player.appendChild(moneyAmount);

    rootElement.appendChild(player);

    DOMSource source = new DOMSource(document);

    Transformer tf = TransformerFactory.newInstance().newTransformer();
    tf.setOutputProperty(OutputKeys.INDENT, "yes");
    tf.setOutputProperty(OutputKeys.METHOD, "xml");
    tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

    StreamResult result = new StreamResult(scores);
    tf.transform(source, result);

} catch (ParserConfigurationException | SAXException | IOException | TransformerException ex) {
    ex.printStackTrace();
}