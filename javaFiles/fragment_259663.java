import java.io.StringReader;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

public class XPathTags {
    private static String xml1=
"<tag l='0'>"+
"    <tag l='1'>"+
"        <tag l='2'>333</tag>"+
"    </tag>"+
"    <tag l='1'>"+
"        <tag l='2'>"+
"            <tag l='3'>333</tag>"+
"       </tag>"+
"   </tag>"+
"</tag>";

    private static String xml2=
"<tag>"+
"    <tag>"+
"        <tag>333</tag>"+
"    </tag>"+
"    <tag>"+
"        <tag>"+
"            <tag>333</tag>"+
"       </tag>"+
"   </tag>"+
"</tag>";

    private static String xpathExpr1=
"//tag[text()=333]/ancestor::*/@l";
    private static String xpathExpr2=
"//tag[text()=333]";

    public static void main(String[] args) {
        try {
            XPath xpath = XPathFactory.newInstance().newXPath();
            XPathExpression expr = xpath.compile(xpathExpr1);
            NodeList nodeList = (NodeList) expr.evaluate(new InputSource(new StringReader(xml1)),XPathConstants.NODESET);
            String resultString = "";
            for( int i = 0; i != nodeList.getLength(); ++i ) {
                resultString += nodeList.item(i).getNodeValue();
            }
            System.out.println(resultString);

            resultString = "";
            expr = xpath.compile(xpathExpr2);
            XPathExpression anc = xpath.compile("ancestor::*");
            nodeList = (NodeList) expr.evaluate(new InputSource(new StringReader(xml2)),XPathConstants.NODESET);
            for( int i = 0; i != nodeList.getLength(); ++i ) {
                Node n = (Node) nodeList.item( i );
                NodeList ancestors = (NodeList) anc.evaluate(n,XPathConstants.NODESET);
                for( int j = 0; j != ancestors.getLength(); ++j )
                    resultString += ancestors.item(j).toString().replace("[tag: null]", "tag[0]");
                resultString += System.lineSeparator();
            }
            System.out.println(resultString);

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}