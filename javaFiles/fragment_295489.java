public Map<String, InputStream> assets() throws IOException {
  final XML xml = this.read();
  final List<XML> nodes = xml.nodes("/p/entry[@key='assets']/entry");
  final List<MapEntry> entries = new LinkedList<>();
  for (final XML node : nodes) {
    entries.add(
      new MapEntry<>(
        input.xpath("@key").get(0),
        this.asset(input.xpath("text()").get(0)) // checked exeption here
      )
    );
  }
  return new MapOf<>(entries);
}