File myHtmlFile = new File("input.txt");
String htmlToParse = new Scanner(myHtmlFile).useDelimiter("\\A").next();

Document doc = Jsoup.parse(htmlToParse);
Element chapterBody = doc.body();

Elements allElements = chapterBody
        .select("p.needed-header, p.needed-sub-header, p.needed-text");
for (Element el : allElements)
    System.out.println(el);