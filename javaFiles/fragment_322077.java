final String url = "http://www.informatik.uni-trier.de/~ley/pers/hd/k/Kumar:G=_Praveen.html";
Document doc = Jsoup.connect(url).get();


for( Element element : doc.select("table div.data") )
{
    // System.out.println(element); // Use this line if you need the HTML Element instead of the text
    System.out.println(element.text());
}