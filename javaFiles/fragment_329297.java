final String html = "This is an <b>important</b> line and i <b>want</b> formatting in it";
Document doc = Jsoup.parse(html);

for( Node node : doc.body().childNodes() )
{
    System.out.println(node.toString());
}