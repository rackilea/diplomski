package forum12925616;

import java.io.*;
import javax.xml.bind.*;

public class Demo {

    private static int X = 5;
    private static int Y = 2;

    public static void main(String[] args) throws Exception {
        int[][] data = new int[X][Y];
        for (int x = 0; x < X; x++) {
            for (int y = 0; y < Y; y++) {
                data[x][y] = x;
            }
        }

        // Create this once
        JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

        marshal(jaxbMarshaller, data, System.out);

        FileOutputStream fileOutputStream = new FileOutputStream("src/forum12925616/out.xml");
        marshal(jaxbMarshaller, data, fileOutputStream);
        fileOutputStream.close();
    }

    private static void marshal(Marshaller jaxbMarshaller, int[][] data, OutputStream outputStream) throws Exception {
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        writer.write("<?xml version='1.0' encoding='UTF-8' standalone='yes'?>");
        writer.write("\n<customers>\n");
        for (int i = 0; i < data.length; i++) {
            Customer customer = new Customer();
            customer.setId(data[i][0]);
            jaxbMarshaller.marshal(customer, writer);
            writer.write("\n");
        }
        writer.write("<customers>");
        writer.flush();
    }

}