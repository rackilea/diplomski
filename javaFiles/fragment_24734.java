Set<V> edgesToQ = reverseAdjacencies.get(q);
if (edgesToQ == null) {
  edgesToQ = new HashSet<>();
  reverseAdjacencies.put(q, edgesToQ);
}
edgesToQ.add(p);