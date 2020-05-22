// obtain the first node using your query
while (currentNode.parent != null) {
   Query q = //create the query
   q.setParameter("id", currentNode.getParentId());
   Node currentNode = (Node) q.getSingleResult();
   nodes.add(currentNode); // this is the Set
}