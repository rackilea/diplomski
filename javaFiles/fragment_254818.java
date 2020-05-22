import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class ListClassesExample {
    public static void main(String[] args) throws IOException {
        String content = 
                "<http://weblab.ow2.org/wookie#Anti-social_behaviour> <http://www.w3.org/2000/01/rdf-schema#subClassOf> <http://weblab.ow2.org/wookie#CriminalEvent>.\n" +
                "<http://weblab.ow2.org/wookie#Robbery> <http://www.w3.org/2000/01/rdf-schema#subClassOf> <http://weblab.ow2.org/wookie#CriminalEvent>.\n" +
                "<http://weblab.ow2.org/wookie#Vehicle_crime> <http://www.w3.org/2000/01/rdf-schema#subClassOf> <http://weblab.ow2.org/wookie#CriminalEvent>.\n" +
                "<http://weblab.ow2.org/wookie#Bicycle_theft> <http://www.w3.org/2000/01/rdf-schema#subClassOf> <http://weblab.ow2.org/wookie#CriminalEvent>.\n" +
                "<http://weblab.ow2.org/wookie#CriminalEvent> <http://www.w3.org/2000/01/rdf-schema#subClassOf>  <http://weblab.ow2.org/wookie#Event>.\n" +
                "<http://weblab.ow2.org/wookie#Event> <http://www.w3.org/2000/01/rdf-schema#subClassOf>  <http://weblab.ow2.org/wookie#WookieThing>.\n" +
                "<http://weblab.ow2.org/wookie#Event> <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> <http://www.w3.org/2000/01/rdf-schema#Class>.";

        final Model base = ModelFactory.createDefaultModel();
        try ( InputStream in = new ByteArrayInputStream( content.getBytes() )) { 
            RDFDataMgr.read( base, in, Lang.NTRIPLES );
        }

        System.out.println( "== OWL Classes (no inference) ==" );
        OntModel owlOntology = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM, base );
        for ( OntClass klass : owlOntology.listClasses().toList() ) {
            System.out.println( klass );
        }

        System.out.println( "== RDFS Classes (no inference) ==" );
        OntModel rdfsOntology = ModelFactory.createOntologyModel( OntModelSpec.RDFS_MEM, base );
        for ( OntClass klass : rdfsOntology.listClasses().toList() ) {
            System.out.println( klass );
        }

        System.out.println( "== RDFS Classes (with inference) ==" );
        OntModel rdfsOntologyInf = ModelFactory.createOntologyModel( OntModelSpec.RDFS_MEM_RDFS_INF, base );
        for ( OntClass klass : rdfsOntologyInf.listClasses().toList() ) {
            System.out.println( klass );
        }

        System.out.println( "== End ==");
    }
}