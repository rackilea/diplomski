package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Test {

    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        try {

            // the query you want to run in mongo, you can get it 
            // from a file using a FileReader
            String query = "db.col.find();";

            // the database name you need to use
            String db = "database";

            // run a command from terminal. this line is equivalent to 
            // mongo database --eval "db.col.find()" 
            // it calls the mongo binary and execute the javascript you 
            // passed in eval parameter. It should work for both unix and 
            // windows 
            Process pr = rt.exec(new String[]{"mongo", db, "--eval", query});
            // read the output of the command
            InputStream in = pr.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder out = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }

            // print the command and close outputstream reader
            System.out.println(out.toString());   
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}