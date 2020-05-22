Document document = Jsoup.connect(url).get();
Elements hrs = document.select("hr");
Pattern pattern = Pattern.compile("(\\d+%%\\d+)");

for (Element hr : hrs) {
    String textAfterHr = hr.nextSibling().toString();
    Matcher matcher = pattern.matcher(textAfterHr);

    while (matcher.find()) {
        System.out.println(matcher.group(1)); // <-- There, your data.
    }
}