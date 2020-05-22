Document doc = Jsoup.parse(html, "", Parser.xmlParser());

for (Element el : doc.select("*")){
    if (!el.ownText().isEmpty()){
        for (TextNode node : el.textNodes())
            node.remove();
    }
}

System.out.println(doc);