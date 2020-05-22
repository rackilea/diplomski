package com.sof.test;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ticketcount {

    public static void main(String[] args) throws IOException {
        List<ticket> ticketList = new ArrayList<ticket>();
        String content = "";
        String content1 ="<HTML><HEAD></HEAD><TABLE border=3>";
        FileWriter fw =null;
        BufferedWriter bw=null;
        String Path = "src";


        try {



            File fXmlFile = new File(Path + "\\ticket.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList ticketNodeList = doc.getElementsByTagName("ticket");

            for (int temp = 0; temp < ticketNodeList.getLength(); temp++) {
                Node varNode = ticketNodeList.item(temp);

                if (varNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) varNode;

                    NodeList teamList = eElement.getElementsByTagName("team");
                    NodeList varsionList = eElement.getElementsByTagName("imp");

                    Node teamNode = teamList.item(0);
                    Node impNode = varsionList.item(0);

                    if (teamNode.getNodeType() == Node.ELEMENT_NODE
                            && impNode.getNodeType() ==

                            Node.ELEMENT_NODE) {
                        Element teamElement = (Element) teamNode;
                        Element impElement = (Element) impNode;
                        ticket ticket = new ticket(
                                teamElement.getTextContent(),

                                impElement.getTextContent());
                        ticketList.add(ticket);
                    }
                }


                File file = new File(Path + "\\result1.html");
                if (!file.exists()) {
                    file.createNewFile();
                }

                 fw = new FileWriter(file.getAbsoluteFile());
                 bw = new BufferedWriter(fw);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<ticket, Integer> count = new HashMap<ticket, Integer>();
        for (ticket c : ticketList)
            if (!count.containsKey(c))
                count.put(c, Collections.frequency(ticketList, c));

        List<String> imps = getimps(count);

        List<String> teams = getteams(count);


        content=content+"<tr><th>ticket</th> ";
        for (String s : imps) {

            content=content+"<th>"+s+"</th>";
        }

        content=content+"</tr>";

        System.out.println("---------------------------------");

        for (String m : teams) {
            System.out.println(m + "\t| " + getNumOfteams(m, imps, count));
            content = content + "<tr><td> <font size=6>" + m + "</font></td>" + getNumOfteams(m, imps, count) + "</tr>";

        }
        bw.write(content1 + content + "</TABLE></HTML>");
        bw.close();

        Runtime rTime = Runtime.getRuntime();
        String url = Path + "//result1.html";
        // String url = "C:\\Users\\a561922\\Desktop\\TEST.html";//"D:/hi.html";
        String browser = "C:/Program Files/Internet Explorer/iexplore.exe ";
        File htmlFile = new File(url);
        System.out.println(url);
        Desktop.getDesktop().browse(htmlFile.toURI());

        // Process pc = rTime.exec(browser + url);
        // pc.waitFor();

        // Runtime.getRuntime().exec("C:\\Users\\a561922\\Desktop\\TEST.html");
    }

    private static List<String> getteams(Map<ticket, Integer> count) {
        List<String> teams = new ArrayList<String>();
        for (Map.Entry<ticket, Integer> ent : count.entrySet())
            if (!teams.contains(ent.getKey().getteam()))
                teams.add(ent.getKey().getteam());
        return teams;
    }

    private static String getNumOfteams(String team, List<String> imps,
            Map<ticket, Integer>

            count) {
        StringBuilder builder = new StringBuilder();

        for (String v : imps) {
            Integer cnt = count.get(new ticket(team, v));
            if (cnt == null) {
                cnt = 0;
            }
            builder.append("<td><font size=10>"+cnt + "</font></td>");

        }

        return builder.toString();
    }

    private static List<String> getimps(Map<ticket, Integer> count) {
        List<String> imps = new ArrayList<String>();
        for (Map.Entry<ticket, Integer> ent : count.entrySet())
            if (!imps.contains(ent.getKey().getimp()))
                imps.add(ent.getKey().getimp());
        return imps;
    }
}