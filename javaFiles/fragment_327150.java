import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.parser.Parser;

public class Test {

    public static void main(String[] args) {
        String xml = "<schemans2:ServicepointForAccountRow AccountID=\"123456\" ServicePointID=\"987654\" LongDescription=\"TE Fix Network RES SINGLE PHS/TEP 13 MR/FN TEP Rt 0010/3220 W INA RD, 13203, TUCSON, AZ, 85741-2169, TEP\" UsageInfo=\"Add\" />";
        Document doc = Jsoup.parse(xml, "", Parser.xmlParser());
        List<Node> nodes = doc.childNodes();
        for(Node n : nodes) {
            System.out.println(n.attr("ServicePointID"));
        }
    }
}