private void loadTree(Tree tree, Object parentID, Node element){

        if(tree == null || element == null){
            return;
        }

        final String itemID = (element.getNodeType() == Node.TEXT_NODE ? element.getNodeValue() : element.getNodeName()).trim();

        if (itemID.equals("#document")) {
            loadTree(tree, null, element.getChildNodes().item(0));
            return;
        }

        if(itemID.length() == 0){
            return;
        }
//add this two lines
        Object item = tree.addItem();
        tree.setItemCaption(item, itemID);

        if(parentID != null){
            tree.setParent(item, parentID);
        }

        NodeList children = element.getChildNodes();
        for(int i = 0, n = children.getLength(); i < n; i++){

            loadTree(tree, item, children.item(i));
        }

        if(itemID.equals("root")){
            tree.expandItem(item);
        }

        if(children.getLength() == 0){
            tree.setChildrenAllowed(item, false);
        }
    }