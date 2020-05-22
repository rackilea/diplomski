//I suggest to use constants
private static final String ANSWER_NODE_NAME = "answer";

// Adding the anwser to the original document
NodeList answerNodeList = documentAnswer.getElementsByTagName("*");
for (int m = 1; m < answerNodeList.getLength(); m++) {
    Node answerNode = answerNodeList.item(m);
    if (answerNode.getNodeType() == Node.ELEMENT_NODE) {
        if (child.equals(answerNode.getNodeName())) {


            //Check if answer node already exists
            //if it does, update its content instead of appending a new answer node
            NodeList children = node.getChildNodes();

            boolean answerNodeExists = false;
            for(int j = 1; j < children.getLength(); j++){
                Node origDocumentChild = children.item(j);

                //check if node is <answer>
                if (origDocumentChild.getNodeName().equals(ANSWER_NODE_NAME)) {

                    //set new answer content
                    origDocumentChild.setTextContent("new answer 123");
                    answerNodeExists = true;
                    break;
                }
            }

            if (!answerNodeExists) {
                Element answer = document.createElement("answer");
                answer.appendChild(document.createTextNode(answerNode.getTextContent()));
                node.appendChild(answer);
                break;
            }               
        }
    }
}