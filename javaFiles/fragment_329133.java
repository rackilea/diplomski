import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

public class ListInstancesExample {
    public static void main(String[] args) {
        // Load the wine ontology.
        final OntModel model = ModelFactory.createOntologyModel( OntModelSpec.OWL_DL_MEM );
        model.read( "http://www.w3.org/TR/owl-guide/wine.rdf" );

        // Get the Merlot class.
        final OntClass merlot = model.getOntClass( "http://www.w3.org/TR/2003/PR-owl-guide-20031209/wine#Merlot" );

        // Print each of its instances.
        for ( final ExtendedIterator<? extends OntResource> merlots = merlot.listInstances(); merlots.hasNext(); ) {
            System.out.println( merlots.next() );
        }
    }
}