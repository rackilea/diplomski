public String GetArticleBody(Document adoc)
{
    //Document totalbody = (Document)adoc.select("article *").first();
    //Element totalbody = adoc.select("article *").first();
    //Elements paragraphs = adoc.select("article * > p);
    Elements paragraphs = adoc.select("article").first().select("p");
    String body = "test";
    for (Element p : paragraphs)
    {
        body = StringAttacher(body, p.text());
    }
    System.out.println(body);
    return body;
}