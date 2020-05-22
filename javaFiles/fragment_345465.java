public String convert(String input, String wordToReplace, String replacement) {
  StringBuilder result = new StringBuilder();
  String[] lines = input.split("\n");
  for (String line : lines) {
    boolean isFirst = true;
    for (String current : line.split("\\s")) {
      if (!isFirst)
        result.append(" ");
      isFirst = false;
      if (current.equals(wordToReplace))
        current = replacement;
      result.append(current);
    }
    result.append("\n");
  }

  return result.toString().trim();
}