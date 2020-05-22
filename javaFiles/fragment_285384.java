public static void main(String[] args) {
    String HTMLSTring= "<form><table><tr><th>First</th><th>Second</th><th>Third</th></tr><tr><td><input type=\"text\" name=\"elems[][f]\" value=\"one\" /></td><td><input type=\"text\" name=\"people[][s]\" value=\"two\" /></td><td><input type=\"text\" name=\"people[][t]\" value=\"three\" /></td></tr><tr><td><input type=\"text\" name=\"elems[][f]\" value=\"one1\" /></td><td><input type=\"text\" name=\"people[][s]\" value=\"two2\" /></td><td><input type=\"text\" name=\"people[][t]\" value=\"three3\" /></td></tr></table><input type=\"submit\" value=\"next\" />";

    Document document = Jsoup.parse(HTMLSTring);
    Elements tables = document.select("table");
    for (Element table : tables){
        Elements ths = table.getElementsByTag("th");
        for(Element th : ths)
        {
            System.out.println(th.text());
        }
    }
}