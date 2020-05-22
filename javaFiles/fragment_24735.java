// Remove the in-edges to r.
for (V p : reverseAdjacencies.remove(r)) {
  adjacencies.get(p).remove(r);
}
// Remove r and all its out-edges
adjacencies.remove(r);