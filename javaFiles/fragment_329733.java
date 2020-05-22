package com.sof.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLFile2 {
    List<Detail> arrayList = new ArrayList<Detail>();

    public static void main(String argv[]) {

        try {

            File fXmlFile = new File(
                    "D:\\StackOverFlow\\DomParserTest\\src\\tvs.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            ReadXMLFile2 readXMLFile = new ReadXMLFile2();
            doc = readXMLFile.readNodes(doc);
            Document document = dBuilder.newDocument();

            readXMLFile.saveXml(readXMLFile.editXml(document));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Document editXml(Document document) throws Exception {

        Element roote = document.createElement("TVS");
        Element tvelement = null;

        Collections.sort(arrayList);


        for (Detail detail : arrayList) {

            tvelement = document.createElement("TV");

            Attr attr = document.createAttribute("TotalValue");

            attr.setValue("" + detail.getPrice() * detail.getInStock());
            tvelement.setAttributeNode(attr);

            Element det = document.createElement("Detail");
            attr = document.createAttribute("Name");

            attr.setValue(detail.getName());
            det.setAttributeNode(attr);
            attr = document.createAttribute("Model");

            attr.setValue(detail.getModel());
            det.setAttributeNode(attr);
            attr = document.createAttribute("Instock");

            attr.setValue("" + detail.getInStock());
            det.setAttributeNode(attr);

            tvelement.appendChild(det);

            roote.appendChild(tvelement);

        }
        document.appendChild(roote);

        return document;
    }

    public Document readNodes(Document doc) {

        NodeList nList = doc.getElementsByTagName("Detail");

        Detail detail = null;
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;
                detail = new Detail();

                detail.setName(eElement.getElementsByTagName("Name").item(0)
                        .getTextContent());
                detail.setModel(eElement.getElementsByTagName("Model").item(0)
                        .getTextContent());
                detail.setInStock(Integer.parseInt(eElement
                        .getElementsByTagName("InStock").item(0)
                        .getTextContent()));
                detail.setPrice(Integer
                        .parseInt(eElement.getElementsByTagName("Price")
                                .item(0).getTextContent()));

            }

            arrayList.add(detail);
        }
        return doc;
    }

    public void saveXml(Document doc) throws Exception {
        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory
                .newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("file.xml"));
        transformer.transform(source, result);
        System.out.println("File saved!");
    }

}