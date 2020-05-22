package com.github.davidepastore.stackoverflow35304577;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Stackoverflow 35304577 question.
 *
 */
public class App {
    public static void main( String[] args )
    {
        List<Element> elements = new ArrayList<Element>();
        try {
            Document doc = Jsoup.connect("http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml").get();
            for (Element e : doc.select("entry")){
                elements.add(e);
                String updated = e.select( "updated" ).text();
                String artist = e.select( "im|artist" ).text();
                String releaseDate = e.select( "im|releasedate" ).text();
                System.out.println(updated + " - " + artist + " - " + releaseDate);
                ListItem item = new ListItem(updated, artist, releaseDate);
                //rest of the code to add the new item to a data store
            }
            System.out.println("Number of entries: " + elements.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}