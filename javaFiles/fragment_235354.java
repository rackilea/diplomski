// attempt to count html elements in string - incorrect code, see below 
public static int countHtmlElements(String content) {
    Document doc = Jsoup.parse(content);
    Elements elements = doc.select("*");
    return elements.size()-4;
}