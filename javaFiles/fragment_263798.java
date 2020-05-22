Elements elements = docx.select("span.mw-headline, li > a");

boolean inPeopleSection = false;
for (Element elem : elements) {
    if (elem.className().equals("mw-headline")) {
        // It's a headline
        inPeopleSection = elem.id().equals("People");
    } else {
        // It's a link
        if (inPeopleSection) {
            System.out.println(elem.text());
        }
    }
}