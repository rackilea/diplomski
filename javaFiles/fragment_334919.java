for (Tile p : platforms) {
  if (p == null) {
    continue; // or break, whatever is better in your case
  }
  if (p.y == br.y && br.x >= p.x && bl.x <= p.x + p.width) {
    // ...
  }
}