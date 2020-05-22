private String imgUrl(Document doc) {
    for (Element m : doc.getElementsByTag("meta")) {
        if ("og:image".equals(m.attr("property")))
            return m.attr("content");
    }
    return null;
}