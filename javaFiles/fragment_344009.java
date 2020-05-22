public void addEdge(int fromNodeID, String edgeData) {
    Node node = getNodeByID(fromNodeID);
    for (int pos = 0; pos < edgeData.length(); pos += 2) {
        int destNodeID = Integer.parseInt(edgeData.substring(pos, pos+1));
        int weight = Integer.parseInt(edgeData.substring(pos + 1, pos + 2);
        node.addEdge(getNodeByID(destNodeID), weight);
    }
}