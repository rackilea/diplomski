public static void main(String[] args) throws Exception {
    Document doc = Jsoup.connect("http://source-url").get();
    Elements spanTags = doc.getElementsByTag("span");
    for (Element spanTag : spanTags) {
        String text = spanTag.ownText();
        System.out.println(text);
    }
}