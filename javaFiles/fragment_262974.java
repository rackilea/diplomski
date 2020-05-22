List<Consumer<String>> aSetters =
  Arrays.asList(
    s -> startRow = s,
    s -> startCol = s,
    s -> endRow = s,
    s -> endCol = s,
    s -> color = s,
    s -> piece = s);

List<Consumer<String>> eSetters =
  Arrays.asList(
    s -> piece = s,
    s -> color = s,
    s -> startRow = s,
    s -> startCol = s,
    s -> endRow = s,
    s -> endCol = s);

List<Consumer<String>> setters; // initialize to aSetters or eSetters accordingly

for (int i = 0; i < bits.length; i++) {
  setters.get(i).accept(bits[i]);
}