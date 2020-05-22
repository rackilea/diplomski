package naveed.workingfiles;

import java.io.*;
import com.artofsolving.jodconverter.openoffice.connection.*;
import com.artofsolving.jodconverter.openoffice.converter.*;
import com.artofsolving.jodconverter.*;

public class DocToPdf {

    public static void main(String[] args) throws Exception {

        //Creating the instance of OpenOfficeConnection and 
        //passing the port number to SocketOpenOfficeConnection constructor 
        OpenOfficeConnection con = new SocketOpenOfficeConnection(8100);

        //making the connection with openoffice server
        con.connect();

        // making the object of doc file and pdf file
        File inFile = new File("sample.docx");

        //this is the final converted pdf file
        File outFile = new File("sample.pdf");

        //making the instance 
        DocumentConverter converter = new OpenOfficeDocumentConverter(con);

        //passing both files objects
        converter.convert(inFile, outFile);

        con.disconnect();
    }

}