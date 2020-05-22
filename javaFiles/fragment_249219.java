String text = "no way oh my god it cannot be";
    Matcher m = Pattern.compile("\\b\\w{3,}\\b").matcher(text);

    StringBuilder sb = new StringBuilder();
    int last = 0;
    while (m.find()) {
        sb.append(text.substring(last, m.start()));
        sb.append(m.group(0).toUpperCase());
        last = m.end();
    }
    sb.append(text.substring(last));

    System.out.println(sb.toString());
    // prints "no WAY oh my GOD it CANNOT be"