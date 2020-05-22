TagNode root = htmlCleaner.clean(url);
// Xpath to 'a'
Object[] foundList = root.evaluateXPath("//div/p[@class='name']/a");
if(foundList == null || foundList.length < 1) {
    return;
}

TagNode aNode = (TagNode)foundList[0];
String aNodeTextContent = aNode.getText();

// Xpath to 'span'
foundList = root.evaluateXPath("//div/p[@class='name']/span");
if(foundList == null || foundList.length < 1) {
    return;
}

TagNode spanNode = (TagNode)foundList[0];
String spanNodeTextContent = spanNode.getText();