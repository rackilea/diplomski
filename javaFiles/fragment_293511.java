//get tag           
// ** I use "Environment" with upper E because XML is case-sensitive
Node environment = doc.getElementsByTagName("Environment").item(0);

//check environment id 
if(environment.getAttributes().getNamedItem("id").getNodeValue().equals("..."))
{

}