package test;

import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RunReport {

public static void main(String[] args){
    String xmlcontent="<Results>"
            + "<ResultSet fetchSize=\"2\">"
            + "<data rowNumber=\"1\">"
            + "<a>29379155</a>"
            + "<b>2013-01-31</b>"
            + "</data>"
            + "<data rowNumber=\"2\">"
            + "<a>29379576</a>"
            + "<b>2013-01-31</b>"
            + "</data>"
            + "</Results>"
            + "</ResultSet>";
    Document doc = Jsoup.parse(xmlcontent);
    List<Element> resultSet = doc.getElementsByTag("data");
    for(int i=0; i<resultSet.size();i++){
        Element RsRecord = resultSet.get(i);
        Elements columns = RsRecord.children();
        for(Element column:columns){
            System.out.println("Row id:"+i+",Column Node name:"+column.nodeName()+",Value="+column.ownText());
        }

    }

}
}