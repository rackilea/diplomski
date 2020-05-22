for (int r = 0; r < M; r++) {
  for (int c = 0; c < N; c++) {
    Node n = nodes[r][c];
    List<Node> neighbors = n.neighbors;
    if (r > 0) {     // has north
      neighbors.add(nodes[r-1][c]);
    }
    if (r < M - 1) { // has south
      neighbors.add(nodes[r+1][c]);
    }
    if (c > 0) {     // has west
      neighbors.add(nodes[r][c-1]);
    }
    if (c < N - 1) { // has east
      neighbors.add(nodes[r][c+1]);
    }
  }
}