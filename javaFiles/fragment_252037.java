Document doc = Jsoup.connect(url).get();
    Elements links = doc.select("a[href]");

    for (Element link : links) {
        if(link.attr("abs:href").contains(studentName) || link.text().contains(studentName)){
            studentLinkList.add(link.attr("abs:href"));
        }
    }