private boolean contains(TrieNode node, String s) {
String communsubString = checkEdgeString(node.getNext(), s);
String restString = s.substring(communsubString.length());
if (node.getNext() != null && !node.getNext().isEmpty()) {
    for (TrieNode nextNodeEdge : node.getNext()) {
        if (nextNodeEdge.getEdge().equals(communsubString)) {
            if (!restString.isEmpty()) {
                if ( contains(nextNodeEdge, restString) ) {
                      return true;
                }

            } else { 
                return true;
            }


        }

    }
}
return false;
}