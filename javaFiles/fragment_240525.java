XmlPath xmlpath = new XmlPath(responseXML);
List<Node> holidayNodes = xmlpath.getList("Holidays.Holiday.findAll{it.Flight.@MultiLegOutboundFlight=='true'}");
List<String> itineraryList = new ArrayList<>();
for(Node node: holidayNodes){
itineraryList.add(node.getAttribute("ItineraryId"));
}
System.out.println(itineraryList);