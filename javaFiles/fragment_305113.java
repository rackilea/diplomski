import java.util.regex.Pattern;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HelloWorld {

public static void main(String[] args) {

    Connection.Response res = null;
    Document doc = null;
    Boolean OK = true;
    int start = 0;
    String query;
    ArrayList<String> tempList = new ArrayList<>();
    ArrayList<String> games = new ArrayList<>();
    Pattern r = Pattern.compile("title=\"(.*)\" a");

    try {   //first connection with GET request
        res = Jsoup.connect("https://play.google.com/store/apps/category/GAME_ACTION/collection/topselling_free")
                .method(Method.GET)
                .execute(); 
        doc = res.parse();
    } catch (Exception ex) {
        //Do some exception handling here
    }
    for (int i=1; i <= 60; i++) {    //parse the result and add it to the list
        query = "div.card:nth-child(" + i + ") > div:nth-child(1) > div:nth-child(3) > h2:nth-child(2) > a:nth-child(1)";
        tempList.add(doc.select(query).toString());
    }

    while (OK) {    //loop until you get the same results again
        start += 60;    
        System.out.println("now at number " + start);
        try {      //send post request for each new page
            doc = Jsoup.connect("https://play.google.com/store/apps/category/GAME_ACTION/collection/topselling_free?authuser=0")
                    .cookies(res.cookies())
                    .data("start", String.valueOf(start))
                    .data("num", "60")
                    .data("numChildren", "0") 
                    .data("ipf", "1")
                    .data("xhr", "1")
                    .post();
        } catch (Exception ex) {
            //Do some exception handling here
        }
        for (int i=1; i <= 60; i++) {    //parse the result and add it to the list
            query = "div.card:nth-child(" + i + ") > div:nth-child(1) > div:nth-child(3) > h2:nth-child(2) > a:nth-child(1)";
            if (!tempList.contains(doc.select(query).toString())) {
                tempList.add(doc.select(query).toString());
            } else {    //we've seen these games before, time to quit
                OK = false;
                break;
            }               
        }   
    }
    for (int i = 0; i < tempList.size(); i++) {    //remove all redundent info.
        Matcher m = r.matcher(tempList.get(i));
        if (m.find()) {
            games.add(m.group(1));
            System.out.println((i + 1) + " " + games.get(i));
        }           
    }
}
}