for (Element link : links) 
{
    String url = link.attr("href");
    String result = url.split("-")[1].replace("/","");
    System.out.println(result);
}