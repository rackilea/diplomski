XdmValue matchList = xPathSelector.evaluate();
        XdmItem firstItem = matchList.itemAt(0);
        if (firstItem instanceof XdmNode) {
           XdmNode xdmNode = (XdmNode) firstItem;
           XdmNodeKind nodeKind = xdmNode.getNodeKind();
           if (nodeKind == XdmNodeKind.ELEMENT) {
              return xdmNode.toString();
           }
        }
        return firstItem.getStringValue();