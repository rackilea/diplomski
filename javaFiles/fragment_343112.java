String input = Files.toString(file, Charsets.US_ASCII);
Iterable<String> fields =
    Splitter.on(" ")
            .omitEmptyStrings()
            .split(input);
List<Coord> coords = Lists.newArrayList();
for (List<String> group: Iterables.partition(fields, 3)) {
    String t = group.get(0);
    double x = Double.parseDouble(group.get(1));
    double y = Double.parseDouble(group.get(2));
    coords.add(new Coord(t, x, y));
}