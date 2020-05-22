public void execute1(String html) {
        Document doc = Jsoup.parse(html);
        // first approach: remove every <p> to simplify document
        Elements paragraphs = doc.select("p");
        for (Element paragraph : paragraphs) {
            paragraph.remove();
        }
        // then one selector will return what you want in both cases
        System.out.println(selectSecondDivAfterH2WithText(doc, "Blah 1"));
        System.out.println(selectSecondDivAfterH2WithText(doc, "Blah 2"));
    }

    private Element selectSecondDivAfterH2WithText(Document doc, String text) {
        return doc.select("h2:contains(" + text + ")+div+div").first();
    }