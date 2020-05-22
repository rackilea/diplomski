public boolean isConnected(String s) {
    Set<String> visited = new HashSet<String>();
    isConnected(s, visited);
    return visited.size() == nodes.size();
}

private void isConnected(String s, Set<String> visited) 
{
    visited.add(s);
    for (String child : listOfChildren(s)) {
        if (!visited.contains(s)) {
            isConnected(child, visited);
        }
    }
}