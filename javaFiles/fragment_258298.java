public static void main(String[] args) throws MalformedURLException, SAXException, IOException{

 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

// Get the DOM Builder
DocumentBuilder docBuilder;
try {
    docBuilder = factory.newDocumentBuilder();
    String dstation ="Dublin%20Pearse";

    URL url = new URL("http://api.irishrail.ie/realtime/realtime.asmx/getStationDataByNameXML?StationDesc=" + dstation);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.setDoOutput(true);
    connection.connect();
    Document doc = (Document) docBuilder.parse(connection.getInputStream());
    doc.getDocumentElement().normalize();
    NodeList trains = doc.getElementsByTagName("objStationData");
    NodeList nodes = trains.item(0).getChildNodes();

    for(int i = 0; i<nodes.getLength(); i++){
        if(nodes.item(i).getNodeName().equals("Direction")){   // what should go here 
            // do something
        }

    }
} catch (ParserConfigurationException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}

}