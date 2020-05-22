private void listNodes(NodeList nodeList){


    // Loop through the node list
    for (int temp = 0; temp < (nodeList != null ? nodeList.getLength() : 0); temp++) {

        Node node = nodeList.item(temp);
        // if node is element
        if (node.getNodeType() == Node.ELEMENT_NODE) {

            // create element from node
            Element element = (Element) node;

            // get tag name from element
            Log.d("tag", "tag/node: " + element.getTagName());

            // if node has children repeat the loop until last child
            if (node.hasChildNodes()) {

                listNodes(node.getChildNodes());

            }

        }

    }

}