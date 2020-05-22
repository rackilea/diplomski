public class htmlCrawler{

    public static db_Connection db = new db_Connection();

    public htmlCrawler(String url){

    getLinksFromPage(url);
}

public boolean checkInDb(String url){
//your data base logic here
}

public boolean getLinksFromPage(String url){

//your jsoup thing

//the loop

Elements questions = doc.select("a[href]").getAll();
for(Element link: questions){
                    {
                      String link = link.attr("abs:href");
                      checkInDb(link);
                       }
    }

}