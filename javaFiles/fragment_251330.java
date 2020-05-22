import java.net.URL;

import com.gargoylesoftware.htmlunit.StringWebResponse;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HTMLParser;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow.CellIterator;


public class ExtractTableData {

    public static void main(String[] args) throws Exception {

        String html = "<div class=\"top_red_bar\">\n" + "                        <div id=\"site-breadcrumbs\">\n"
                + "                            <a href=\"/admin/index.jsp\" title=\"Home\">Home</a>\n"
                + "                            &#124;\n"
                + "                            <a href=\"/admin/queues.jsp\" title=\"Queues\">Queues</a>\n"
                + "                            &#124;\n"
                + "                            <a href=\"/admin/topics.jsp\" title=\"Topics\">Topics</a>\n"
                + "                            &#124;\n"
                + "                            <a href=\"/admin/subscribers.jsp\" title=\"Subscribers\">Subscribers</a>\n"
                + "                            &#124;\n"
                + "                            <a href=\"/admin/connections.jsp\" title=\"Connections\">Connections</a>\n"
                + "                            &#124;\n"
                + "                            <a href=\"/admin/network.jsp\" title=\"Network\">Network</a>\n"
                + "                            &#124;\n"
                + "                             <a href=\"/admin/scheduled.jsp\" title=\"Scheduled\">Scheduled</a>\n"
                + "                            &#124;\n" + "                            <a href=\"/admin/send.jsp\"\n"
                + "                               title=\"Send\">Send</a>\n" + "                        </div>\n"
                + "                        <div id=\"site-quicklinks\"><P>\n"
                + "                            <a href=\"http://activemq.apache.org/support.html\"\n"
                + "                               title=\"Get help and support using Apache ActiveMQ\">Support</a></p>\n"
                + "                        </div>\n" + "                    </div>\n" + "\n"
                + "                    <table border=\"0\">\n" + "                        <tbody>\n"
                + "                            <tr>\n"
                + "                                <td valign=\"top\" width=\"100%\" style=\"overflow:hidden;\">\n"
                + "                                    <div class=\"body-content\">\n" + "\n" + "\n"
                + "<h2>Welcome!</h2>\n" + "\n" + "<p>\n"
                + "Welcome to the Apache ActiveMQ Console of <b>localhost</b> (ID:TOOLCONTROLPJX526-524666-65544585445-2:3)\n"
                + "</p>\n" + "\n" + "<p>\n"
                + "You can find more information about Apache ActiveMQ on the <a href=\"http://activemq.apache.org/\">Apache ActiveMQ Site</a>\n"
                + "</p>\n" + "\n" + "<h2>Broker</h2>\n" + "\n" + "\n" + "<table>\n" + "    <tr>\n"
                + "        <td>Name</td>\n" + "        <td><b>localhost</b></td>\n" + "    </tr>\n" + "    <tr>\n"
                + "        <td>Version</td>\n" + "        <td><b>5.13.3</b></td>\n" + "    </tr>\n" + "    <tr>\n"
                + "        <td>ID</td>\n" + "        <td><b>ID:TOOLCONTROLPJX526-524666-65544585445-2:3</b></td>\n"
                + "    </tr>\n" + "    <tr>\n" + "        <td>Uptime</td>\n"
                + "        <td><b>17 days 13 hours</b></td>\n" + "    </tr>\n" + "    <tr>\n"
                + "        <td>Store percent used</td>\n" + "        <td><b>19</b></td>\n" + "    </tr>\n"
                + "    <tr>\n" + "        <td>Memory percent used</td>\n" + "        <td><b>0</b></td>\n"
                + "    </tr>\n" + "    <tr>\n" + "        <td>Temp percent used</td>\n" + "        <td><b>0</b></td>\n"
                + "    </tr>\n" + "</table>";
        WebClient webClient = new WebClient();
        HtmlPage page = HTMLParser.parseHtml(new StringWebResponse(html, new URL("http://dummy.url.for.parsing.com/")),
                webClient.getCurrentWindow());

        final HtmlTable table = (HtmlTable) page.getByXPath("//table").get(1);

        for (final HtmlTableRow row : table.getRows()) {

            CellIterator cellIterator = row.getCellIterator();

            if (cellIterator.hasNext()) {
                System.out.print(cellIterator.next().asText());
                while (cellIterator.hasNext()) {
                    System.out.print(":" + cellIterator.next().asText());
                }
            }
            System.out.println();
        }

    }

}