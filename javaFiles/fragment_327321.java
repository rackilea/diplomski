String pattern = "(?<desc>.*\\(.*\\).*)\n.*-.*\n(?<data>(?:N/A\n|\\d*\\.\\d*\n)+)";

String rawData = new String(Files.readAllBytes(Paths.get("indata.txt")));
Matcher seriesMatcher = Pattern.compile(pattern).matcher(rawData);
while(seriesMatcher.find()) {
    List<String> series = new ArrayList<>();
    series.add(seriesMatcher.group("desc").trim());
    series.addAll(asList(seriesMatcher.group("data").split("\n")));
    System.out.println(series);
}