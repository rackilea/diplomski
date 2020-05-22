DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
Document doc = factory.newDocumentBuilder().parse("booking-request.xml");
Element bookingRequest = doc.getDocumentElement();
Element contract = (Element)bookingRequest.getElementsByTagName("Contract").item(0);
Element trades = (Element)contract.getElementsByTagName("Trades").item(0);

List<Element> tradeList = new ArrayList<Element>();
NodeList nodeList = trades.getElementsByTagName("Trade");
for(int i=0; i<nodeList.getLength(); i++)
    tradeList.add((Element)nodeList.item(i));

Transformer transformer = TransformerFactory.newInstance().newTransformer();
int i = 0;
for(Element trade: tradeList){
    // remove all children of <Trades>
    while(trades.getFirstChild()!=null)
        trades.removeChild(trades.getFirstChild());

    trades.appendChild(doc.createTextNode("\n            "));
    trades.appendChild(trade);
    trades.appendChild(doc.createTextNode("\n        "));
    ++i;
    transformer.transform(new DOMSource(doc), new StreamResult(new File("trade"+i+".xml")));
}