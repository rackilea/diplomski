String text = "CALDARI_STARSHIP_ENGINEERING";
    text = text.replace("_", " ");

    Matcher m = Pattern.compile("(?<=\\b\\w)\\w+").matcher(text);
    StringBuffer sb = new StringBuffer();
    while (m.find()) {
        m.appendReplacement(sb, m.group().toLowerCase());
    }
    m.appendTail(sb);
    System.out.println("[" + sb.toString() + "]");
    // prints "[Caldari Starship Engineering]"