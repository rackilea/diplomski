import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class JsoupHtmlDirectChildren {
    public static void main(String[] args) {
        String html = "" +
                "<html>                                                                  " +
                "  <body>                                                                " +
                "    <span>HELLO!</span>                                                 " +
                "    <table id=\"myTable\">                                              " +
                "      <tbody>                                                           " +
                "        <tr>                                                            " +
                "          <th>header</th>                                               " +
                "          <!-- <td> tags on a high level in the hierarchy. -->          " +
                "          <td>high level1                                               " +
                "            <table>                                                     " +
                "              <tbody>                                                   " +
                "                <tr>                                                    " +
                "                  <!-- <td> tags on a low level in the hierarchy. -->   " +
                "                  <td>low level1</td>                                   " +
                "                  <td>low level2</td>                                   " +
                "                  <td>low level3</td>                                   " +
                "                </tr>                                                   " +
                "              </tbody>                                                  " +
                "            </table>                                                    " +
                "          </td>                                                         " +
                "          <td>high level2</td>                                          " +
                "          <td>high level3</td>                                          " +
                "        </tr>                                                           " +
                "      </tbody>                                                          " +
                "    </table>                                                            " +
                "  </body>                                                               " +
                "</html>                                                                 ";
        Document doc = Jsoup.parse(html);
        // all first level children TD of the #myTable table
        Elements highLevelTDs = doc.select("#myTable > tbody > tr > td");
        System.out.println("QUANTITY FOUND: "+highLevelTDs.size());
        for (Element td : highLevelTDs) {
            System.out.println("\n\n###HIGH LEVEL TD: "+td);
        }
    }
}