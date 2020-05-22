package com.sof.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Tester {
    public static void main(String[] args) {
        List<Car> carsList=new ArrayList<Car>();
        Set<Car> carsset=new HashSet<Car>();
        try {
            File fXmlFile = new File(
                    "D:\\StackOverFlow\\DomParserTest\\src\\com\\sof\\test\\cars.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("cars");
            Car tempCar=null;
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    tempCar=new Car();
                    Element eElement = (Element) nNode;

                    tempCar.setModel(eElement.getElementsByTagName("model").item(0)
                                    .getTextContent());

                    tempCar.setVersion(eElement.getElementsByTagName("version").item(0)
                                    .getTextContent());
                carsList.add(tempCar);
                carsset.add(tempCar);

                }
            }       
        //    System.out.println(carsset.size()+"\t"+carsList.size());   

            System.out.println("**********************************");
            for(Car cs:carsset)
            {               
                int count=0;
                for(Car cl:carsList)
                {   
                    if(cs.equals(cl))
                    {
                        count=count+1;
                    }
                }
                System.out.println(cs+"\t"+count);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}