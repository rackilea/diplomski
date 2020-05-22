package com.stackoverflow.answers.xpath;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class XPathTest {
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        try {
            URL sampleURL = new URL("http://www.xmlfiles.com/examples/simple.xml");
            Document document = parse(sampleURL);

            List list = document.selectNodes("//food/name");

            System.out.println("Following food items found from the menu:");
            printList(list);

            list = document.selectNodes("//food/price");

            System.out.println("Let's check out some prices:");
            printList(list);

        } catch (DocumentException e) {
            System.out.println("Oops! Couldn't read document...");
            e.printStackTrace();
        } catch (MalformedURLException e) {
            System.out.println("Oops! URL was malformed...");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("rawtypes")
    private static void printList(List list) {
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            Node node = (Node) iterator.next();
            System.out.println(node.getText());
        }

        System.out.println();
    }

    private static Document parse(URL sampleURL) throws DocumentException {
        SAXReader reader = new SAXReader();
        reader.setEncoding("UTF-8");
        return reader.read(sampleURL);
    }
}