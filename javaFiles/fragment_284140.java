package com.sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.protobuf.Message;
import com.googlecode.protobuf.format.XmlFormat;
import com.sample.PersonProtos.Person;

/**
 * This class generate XML output from Object and vice-versa
 * 
 * @author mcapatna
 * 
 */
public class Demo
{
    public static void main(String[] args) throws IOException
    {
        long startDate=System.currentTimeMillis();


        // get the message type from protocol buffer generated class.set the
        // required property
        Message personProto = Person.newBuilder().setEmail("a").setId(1).setName("as").build();
        // use protobuf-java-format to generate XMl from Object.
        String toXml = XmlFormat.printToString(personProto);
        System.out.println("toXMl "+toXml);
        // Create the Object from XML
        Message.Builder builder = Person.newBuilder();
        String fileContent = "";
//      file3 contents same XML String as toXml
        fileContent = readFileAsString("C:\\file3.xml");
        // call protobuf-java-format method to generate Object
        XmlFormat.merge(fileContent, builder);
        Message msg= builder.build();
        System.out.println("From XML"+XmlFormat.printToString(msg));
        long endDate=System.currentTimeMillis();
        System.out.println("Time Taken: "+(endDate-startDate));
        System.out.println("-Done-");
    }

    private static String readFileAsString(String filePath) throws IOException
    {
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead = 0;
        while ((numRead = reader.read(buf)) != -1)
        {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
    }
}