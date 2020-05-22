//presuming arrXMLString is a List 
List<JSONInput> saveArrayList = new ArrayList<JSONInput>();
for ( int i = 0; i < arrXMLString.size(); i++ ){
    JSONInput jsonInput = arrXMLString.get(i);
    publisher.send(jsonInput);
    saveArrayList .add(jsonInput);
    if ( i % 500 == 0 && i > 0 ){
        SentService.sendArraylist(tempList);  
        saveArrayList .clear();
    }
}