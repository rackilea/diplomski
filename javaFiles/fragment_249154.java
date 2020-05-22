package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test {
    public static void main(String args[]) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new File(
                "src/file.xml"));
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document doc1 = builder.parse(fileInputStream);
        doc1.getDocumentElement().normalize();
        NodeList kList1 = doc1.getElementsByTagName("item");
        List<String> alist=new ArrayList<String>();
        StringBuilder stringBuilder=new StringBuilder();
        String SystemsListByYear;
        for (int temp = 0; temp < kList1.getLength(); temp++) {
            Node kNode1 = kList1.item(temp);
             System.out.println("\nCurrent Element :" + kNode1.getNodeName());
            if (kNode1.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) kNode1;
                System.out.println("node name"+eElement.getNodeName());
                Node in=eElement.getFirstChild();
                if((in.getTextContent()!=null)&&!(in.getTextContent()).isEmpty()&& !(in.getTextContent().length()==0))
                stringBuilder.append(in.getTextContent());
                }
        }
        String s=new String(stringBuilder);
        String sa[]=s.split("\n");
        System.out.println("size"+sa.length);
        for(String st:sa)
        {
         System.out.println(st);
        }
    }
}