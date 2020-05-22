import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

public class OWLSuperclassExample {
    public static void main(String[] args) {
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM_RULE_INF);
        model.read("http://www.lsi.upc.edu/~%20oromero/EUCarRental.owl");
        OntClass rentalAgreement = 
            model.getOntClass("http://www.owl-ontologies.com/unnamed.owl#RentalAgreement");
        ExtendedIterator<OntClass> classes = rentalAgreement.listSuperClasses();
        while ( classes.hasNext() ) {
            System.out.println( "Superclass: " + classes.next() );
        }
        System.out.println("Completed.");
    }
}