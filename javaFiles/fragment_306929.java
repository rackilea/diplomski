public static String extractText(File file) throws IOException {
    StringBuilder sb = new StringBuilder();
    Document document = Jsoup.parse(file, null);
    Elements body = document.getAllElements();
    for (Element e : body) {
        for (TextNode t : e.textNodes()) {
            String s = t.text();
            if (StringUtils.isNotBlank(s))
                sb.append(t.text()).append(" ");
        }
    }
    return sb.toString();
}