/**
  * Adds the node aNewChild to the end of the list of children of this node.
  * If the newChild is already in the tree, it is first removed.
  * @param aNewChild The node to add.If it is a DocumentFragment object,
  *                  the entire contents of the document fragment are moved
  *                  into the child list of this node
  * @return The node added or null.
  */
  public Node AddNode(Node aNode, Node aOldNode) {
        CustomLog.i(TAG, "AddNode()" );

        if (aNode == null) {
            CustomLog.e(TAG, "aNode is null!");
            return null;
        }

        if (aOldNode == null) {
            CustomLog.e(TAG, "aOldNode is null!");
            return null;
        }

        Document document = aNode.getOwnerDocument();

        aOldNode = document.adoptNode(aOldNode);

        return aNode.appendChild(aOldNode);

    } /* Node AddNode(Node aNode, Node aOldNode) **/