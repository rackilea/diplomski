package doodle;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) {

        Document doc = Jsoup
                .parse("<dict><key>Finance</key><dict><key>MainContent</key><array><string>Transactions</string><string>Booking Sales</string><string>Export Booking</string><string>Operation Revenue</string></array></dict><key>AboutUs</key><dict><key>MenuItems</key><array><dict><key>name</key><string>Ship Owning</string><key>submenu</key><array><string>Orient Express Lines FZCO</string><string>Transworld Bulk Carriers FZCO</string></array></dict><dict><key>name</key><string>Feeder</string><key>submenu</key><array><string>Orient Express Lines FZCO</string><string>Shreyas Shipping And Logistics Ltd</string></array></dict></dict>");

        Elements elements = doc.select("string");

        for (Element element : elements) {
            System.out.println(element.text());
        }

    }

}