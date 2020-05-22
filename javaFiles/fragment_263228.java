import java.io.Reader;

import org.coode.owlapi.rdfxml.parser.OWLRDFConsumer;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyLoaderConfiguration;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import uk.ac.manchester.cs.owl.owlapi.turtle.parser.TurtleParser;


public class ExampleOWLRDFConsumer {
    public static void main(String[] args) throws OWLOntologyCreationException, OWLOntologyStorageException {
        // Create an ontology.
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLDataFactory factory = manager.getOWLDataFactory();
        OWLOntology ontology = manager.createOntology();

        // Create some named individuals and an object property.
        String ns = "http://example.org/";
        OWLNamedIndividual tom = factory.getOWLNamedIndividual( IRI.create( ns+"Tom" ));
        OWLObjectProperty likes = factory.getOWLObjectProperty( IRI.create( ns+"likes" ));
        OWLDataProperty age = factory.getOWLDataProperty( IRI.create( ns+"age" ));
        OWLNamedIndividual anna = factory.getOWLNamedIndividual( IRI.create( ns+"Anna" ));

        // Add the declarations axioms to the ontology so that the triples involving
        // these are understood (otherwise the triples will be ignored).
        for ( OWLEntity entity : new OWLEntity[] { tom, likes, age, anna } ) {
            manager.addAxiom( ontology, factory.getOWLDeclarationAxiom( entity ));
        }

        // Print the the ontology to see that the entities are declared. 
        // The important result is
        //  <NamedIndividual rdf:about="http://example.org/Tom"/>
        // with no properties
        manager.saveOntology( ontology, System.out );

        // Create an OWLRDFConsumer for the ontology.  TurtleParser implements AnonymousNodeChecker, so 
        // it was a candidate for use here (but I make no guarantees about whether it's appropriate to 
        // do this).  Since it won't be reading anything, we pass it a null InputStream, and this doesn't
        // *seem* to cause any problem.  Hopefully the default OWLOntologyLoaderConfiguration is OK, too.
        OWLRDFConsumer consumer = new OWLRDFConsumer( ontology, new TurtleParser((Reader) null), new OWLOntologyLoaderConfiguration() );

        // The consumer handles (IRI,IRI,IRI) and (IRI,IRI,OWLLiteral) triples.
        consumer.handle( tom.getIRI(), likes.getIRI(), anna.getIRI() );
        consumer.handle( tom.getIRI(), age.getIRI(), factory.getOWLLiteral( 35 ));

        // Print the ontology to see the new object and data property assertions.  The import contents is
        // still Tom: 
        //   <NamedIndividual rdf:about="http://example.org/Tom">
        //     <example:age rdf:datatype="http://www.w3.org/2001/XMLSchema#integer">35</example:age>
        //     <example:likes rdf:resource="http://example.org/Anna"/>
        //  </NamedIndividual>
        manager.saveOntology( ontology, System.out );
    }
}