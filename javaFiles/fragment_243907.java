String html = "YOUR HTML";
    String regex = "<a href\\s?=\\s?\"([^\"]+)\">";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(html);
    int index = 0;
    while (matcher.find(index)) {
        String wholething = matcher.group(); // includes "<a href" and ">"
        String link = matcher.group(1); // just the link
        // do something with wholething or link.
        index = matcher.end();
    }