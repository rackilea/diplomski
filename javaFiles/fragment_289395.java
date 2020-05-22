package packagechain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.stream.Stream;

public class Text {
     String fileName;
     FileReader fr;
     BufferedReader in;
     Stream<String> lines;
     Iterator<String> l;
     boolean hasLine;

    public Text() throws FileNotFoundException{
         fileName = "....4-line.txt";
         fr = new FileReader(fileName);
         in = new BufferedReader(fr);   
         lines = in.lines();
         l = lines.iterator();
         hasLine = true;
    }

    public String nexline() {

        if(l.hasNext()) {
            String nl = l.next();
            System.out.println("Next line; "+nl);
            return nl
        }
        else {
            System.out.println("No new line!");
            hasLine = false;
            return null;
        } 
    }    
}