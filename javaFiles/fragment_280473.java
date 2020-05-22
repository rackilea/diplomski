private void orderAsFirstChild(String childName, Node parentNode) throws RepositoryException {
    if (parentNode.hasNode(childName)) {

      // find current first child name
      String firstChildName = Optional.ofNullable(parentNode.getNodes())
          .map(NodeIterator::nextNode)
          .map(node -> {
            try {
              node.getName();
            } catch (RepositoryException e) {
              e.printStackTrace();
            }
            return (String) null;
          }) //
          .orElse(null);
      parentNode.orderBefore(childName, firstChildName);
    }
  }