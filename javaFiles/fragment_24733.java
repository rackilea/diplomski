Map<V, K> edgesFromP = adjacencies.get();
if (edgesFromP == null) {
  edgesFromP = new HashMap<>();
  adjacencies.put(p, edgesFromP);
}
edgesFromP.put(q, nodeData);