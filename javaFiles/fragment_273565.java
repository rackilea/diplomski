public static String findFragment(String html, String fixedStart) {

    Document doc = Jsoup.parse(html);
    Element myBTag = doc
            .select("b:matches(^" + Pattern.quote(fixedStart) + "$)")
            .first();

    StringBuilder sb = new StringBuilder();
    boolean foundNonEmpty = false;

    Node currentSibling = myBTag.nextSibling();
    while (currentSibling != null && !foundNonEmpty) {
        if (currentSibling.nodeName().equals("b")) {
            Element b = (Element) currentSibling;
            if (!b.text().trim().isEmpty())
                foundNonEmpty = true;
        }
        sb.append(currentSibling.toString());
        currentSibling = currentSibling.nextSibling();
    }

    return sb.toString();
}