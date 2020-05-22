doc = Jsoup.parse(new File(path), "UTF-8");
//replace all left-angle tags inside <p> element to "&lt;"
Elements pTags = doc.select("p");
for (Element tag : pTags) {
    //change the boundary of the regex to whatever suits you
    if (tag.html().matches("(.*)<[a-z](.*)")) {
        String innerHTML = tag.html().replaceAll("<(?=[a-z])", "&lt;");
        tag.html(innerHTML);
    }
}