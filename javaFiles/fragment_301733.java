try {
        Document doc = Jsoup.connect("https://www.facebook.com/pages/The-Nanyang-Chronicle/141387533074").timeout(0).get();

        Elements elements = doc.select("code.hidden_elem");
        for (Element e : elements) {
            String eHtml = e.html().replace("<!--", "").replace("-->", "");
            Document eWIthoutComment = Jsoup.parse(eHtml);
            Elements elem = eWIthoutComment.select("h6.uiStreamMessage >span.messageBody");
            for (Element eb : elem) {
                System.out.println(eb.text());                   
            }
        }
    } catch (IOException ex) {
        System.err.println("Error:" + ex.getMessage());
    }