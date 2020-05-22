DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
String available_date = dateFormat.format(new java.util.Date());

if(msg.hasElement("responseError")){
    System.out.println("responseError encountered! " + msg.getElement("responseError").getElement("message"));
}

Element securityDataArray = msg.getElement("securityData");
String ticker = securityDataArray.getElementAsString("security");
String line = "";
String value = "";

Element fieldDataArray = securityDataArray.getElement("fieldData");