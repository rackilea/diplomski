private void listNodes(NodeList list, boolean getValues) {

    for (int temp = 0; temp < (list != null ? list.getLength() : 0); temp++) {

        Node node = list.item(temp);

        if (node.getNodeType() == Node.ELEMENT_NODE) {

            Element element = (Element) node;

            // if you want values then you loop through the tag names and get node values for those tags
            if (getValues) {

                Bundle bundle = new Bundle();

                for(int i = 0; i< nodeNames.size(); i++){

                    bundle.putString(nodeNames.get(i), getNode(nodeNames.get(i),element));

                }

                xmlTableRows.add(bundle);

            } else {
                /// if you want tags just read them from node
                nodeNames.add(element.getTagName());

            }

        }

    }

}