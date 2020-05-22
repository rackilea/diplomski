public static List<String> traverse( Node node ) {
        List<String> results = new LinkedList();
        results.add(node.getNodeName());
        if ( node.getChildNodes().getLength() > 0 ) {
            for ( int i = 0; i < node.getChildNodes().getLength(); i++ )
                results.addAll(traverse(node.getChildNodes().item(i)));
        }
        return results;
    }