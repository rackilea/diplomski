package t1;                        
import java.io.*;
import com.hp.hpl.jena.util.*;
import com.hp.hpl.jena.ontology.*;
import com.hp.hpl.jena.rdf.model.*;
import java.nio.charset.*;

class test {
 public static void main (String[] args) { 
       InputStreamReader lastf = new 
          InputStreamReader(FileManager.get().open("lastfm.txt"),
                            Charset.forName("ISO-8859-1"));

       Model temp=null;
       temp=ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM_RDFS_INF);
       temp.read(lastf,null,"Turtle");
       System.out.println(temp.size());
       temp.write(System.out);
    }
}