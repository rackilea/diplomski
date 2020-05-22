String url ="http://www.dict.cc/englisch-deutsch/trim.html";
Document doc = Jsoup.connect(url)
        .userAgent("Mozilla/5.0 ;Windows NT 6.1; WOW64; AppleWebKit/537.36 ;KHTML, like Gecko; Chrome/39.0.2171.95 Safari/537.36")
        .get();

Elements wordAEls = doc.select("dd a");
for (Element wordA : wordAEls ){
    System.out.println(wordA.ownText());    
}