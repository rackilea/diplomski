String test = "";

Element body = doc.getElementsByTag("body").first();
List<Node> childNodes = body.childNodes();

for(Node node : childNodes){

    if(node instanceof TextNode){
        // These are text nodes, lets see if they are empty or not and add them to the string.
        String nodeString = node.toString();
        if(nodeString != null && !nodeString.trim().isEmpty()){
            test += nodeString;
        }
    } else if (node instanceof Element) {
        // Here is an element, let's see if there is an image.
        Element element = (Element)node;
        Element image = element.children().select("img").first();

        if(image != null)
        {
            test += image.attr("alt");
        }
    }
}