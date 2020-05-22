public void execute2(String html) {
        Document doc = Jsoup.parse(html);
        System.out.println(selectSecondDivAfterH2WithText2(doc, "Blah 1"));
        System.out.println(selectSecondDivAfterH2WithText2(doc, "Blah 2"));
    }

    private Element selectSecondDivAfterH2WithText2(Document doc, String text) {
        int counter = 2;
        // find h2 with given text
        Element h2 = doc.select("h2:contains(" + text + ")").first();
        // select every sibling after this h2 element
        Elements siblings = h2.nextElementSiblings();
        // loop over them
        for (Element sibling : siblings) {
            // skip everything that's not a div
            if (sibling.tagName().equals("div")) {
                // count how many divs left to skip
                counter--;
                if (counter == 0) {
                    // return when found nth div
                    return sibling;
                }
            }
        }
        return null;
    }