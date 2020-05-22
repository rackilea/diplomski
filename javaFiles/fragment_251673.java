public static TileCoordinate parseTitleCoordinate(String key) {
  String[] bits = key.split("-");
  long x = Long.parseLong(bits[0]);
  long y = Long.parseLong(bits[1]);
  long level = Long.parseLong(bits[2]);
  return new TitleCoordinate(x, y, level);
}