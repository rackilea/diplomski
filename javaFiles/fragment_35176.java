public class Example
{
    private static long bytesTotal;


    private Example() { }


    public static Document loadDocument(String url) throws IOException
    {
        final Document doc = Jsoup.connect(url).get();

        bytesTotal += doc.toString().length();

        return doc;
    }
}