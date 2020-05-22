//get tag           
Node environment = doc.getElementsByTagName("Environment").item(0);

//check environment id 
// ** I cast the Node instance (ie environment) into an Element instance
if ( ((Element)environment).getAttribute("id").equals("...") )
{

}