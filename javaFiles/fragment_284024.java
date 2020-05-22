/* this java code need one jar file named with odfdom-java 0.8.6 , and it will able to read any odt file and can store in string and can also change the content of the original file on new or existing file what ever your requirement . if you want to create new file then give new file name and path at the method "document.save("D:/newFile.odt")".
*/

1)--> FileReaderTemp .java

package com.ik.candidate.util;

import java.io.File;

import org.apache.log4j.Logger;
import org.odftoolkit.odfdom.doc.OdfTextDocument;
import org.odftoolkit.odfdom.incubator.search.TextNavigation;
import org.odftoolkit.odfdom.incubator.search.TextSelection;

public class FileReaderTemp {

    public static void main(String[] args) throws Exception {
        parseAll("d:/odt_resume/vrunda_ashar_Rajkot_00.odt");
    }

    public static void parseAll(String fileName) throws Exception {
        Logger logger = Logger.getLogger(FileReaderTemp.class);
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                logger.debug("Sorry File does not Exists!");
            } else if (file.getName().endsWith(".odt")) {
                OpenOfficeParser odt = new OpenOfficeParser();

                //getting contents of odt file in string
                String string = odt.getText(fileName);
                TextNavigation search;
                OdfTextDocument document = (OdfTextDocument) OdfTextDocument.loadDocument(fileName);

                // for replacing Email id
                String emailID="jariya.nilesh99@gmail.com";
            //  String emailID = new FindEmailID().findEmail(string);
                System.out.println("Email is :: " + emailID);
                search = new TextNavigation(emailID, document);
                while (search.hasNext()) {
                System.out.println("Search is : " + search);
            TextSelection item = (TextSelection) search.getCurrentItem();
                item.replaceWith("");
            System.out.println("Email id Removed succesfully :: ");
                    }


                // for replacing contact no
                  String no="9856565698";   
                            //String no = new FindContactNo().findContact(string);
                System.out.println("Contact no is :: " + no);

                    no = no.replace("+", "");
                    // System.out.println("After removed + : " + no);

                    search = new TextNavigation(no, document);
                    // iterate through the search results
                while (search.hasNext()) {
                // System.out.println("Search is No : " + search);
            TextSelection item = (TextSelection) search.getCurrentItem();
                item.replaceWith("");
                        System.out.println("Contact no Removed succesfully :: ");
                    }


                // save the modified document back to a original file other wise it will create new odt file
                document.save(fileName);
            }
        }

        catch (Exception e) {
            //logger.error("Exception : " + e);
            System.out.println("Not found ::");
        }
    }
}