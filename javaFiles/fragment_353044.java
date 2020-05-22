Document doc = Jsoup.parse(labelText); //labelText comes from input
    Elements titleElements = doc.getElementsByTag("pre");
    for (Element pre : titleElements) {
        String content = pre.html().replaceAll("<", "&lt;");
        String content2 = content.replaceAll(">", "&gt;");
        pre.html(content2);
    }

//Save to db..