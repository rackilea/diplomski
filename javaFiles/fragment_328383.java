public String getMap(int x, int y) {
  System.out.printf("getMap('%d', '%d')\n", x, y);
  if (map != null && map[y] != null) {
    String index = map[y].substring(x, x + 1);
    return index;
  }
  System.out.println("Returning null");
  return null;
}