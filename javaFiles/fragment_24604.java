package com.howtodoinjava.xml.sax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TestSaxParser
{
    public static void main(String[] args) throws FileNotFoundException
    {
        //Locate the file OR String
        File xmlFile = new File("D:/temp/sample.xml");

        //Create the parser instance
        UsersXmlParser parser = new UsersXmlParser();

        //Parse the file Or change to parse String
        ArrayList users = parser.parseXml(new FileInputStream(xmlFile));

        //Verify the result
        System.out.println(users);
    }
}