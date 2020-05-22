Elements urls = doc.select("a[href]");

for( Element urlElement : urls )
{
    urlElement.attr("href", urlElement.absUrl("href"));
    System.out.println(urlElement); // Print result directly after changes have been done
}