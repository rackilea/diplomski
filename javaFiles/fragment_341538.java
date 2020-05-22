Page pageContent = pageManager.getContainingPage("/content/my-site/en/cars");
    Node pageContentNode  = pageContent.adaptTo(Node.class);
    try {
        NodeIterator nodeIter = pageContentNode.getNodes("parsys*");
        // iterate nodes
    } catch (RepositoryException e) {
        e.printStackTrace();
    }