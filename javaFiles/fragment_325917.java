// Matches up to the next comma or the end of the line
Pattern CSV_PATTERN = Pattern.compile("(?<=,|^)([^,]*)(,|$)");

List<String> ls = new ArrayList<String>();
Matcher m = CSV_PATTERN.matcher(input);
while (m.find()) {
  ls.add(m.group(1).trim()); // .trim() is optional
}