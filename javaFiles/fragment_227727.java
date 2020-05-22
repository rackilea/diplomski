public class ScanWebSO 
{
public static void main (String args[])
{
    Document doc;
    try{
        doc =        Jsoup.connect("https://www.google.com/search?as_q=&as_epq=%22Yorkshire+Capital%22+&as_oq=fraud+OR+allegations+OR+scam&as_eq=&as_nlo=&as_nhi=&lr=lang_en&cr=countryCA&as_qdr=all&as_sitesearch=&as_occt=any&safe=images&tbs=&as_filetype=&as_rights=").userAgent("Mozilla").ignoreHttpErrors(true).timeout(0).get();
        Elements links = doc.select("li[class=g]");
        for (Element link : links) {
            Elements titles = link.select("h3[class=r]");
            String title = titles.text();

            Elements bodies = link.select("span[class=st]");
            String body = bodies.text();

            System.out.println("Title: "+title);
            System.out.println("Body: "+body+"\n");
        }
    }
    catch (IOException e) {
        e.printStackTrace();
    }
}
}