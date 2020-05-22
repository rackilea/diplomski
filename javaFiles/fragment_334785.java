if (!explored.contains(s)) {
    s.setParent(s);   // here you add the wrong parent - it should be s.setParent(cur)
    s.setDepth(cur.getDepth() + 1);
    frontier.add(s);
    numNodesExplored++;
}