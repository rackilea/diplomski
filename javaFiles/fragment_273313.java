import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;

public class UnionClassExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String NS = "https://stackoverflow.com/q/20561994/1281433/";
        OntModel model = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM );
        model.setNsPrefix( "so", NS );

        OntClass a = model.createClass( NS+"A" );
        OntClass b = model.createClass( NS+"B" );
        OntClass c = model.createClass( NS+"C" );

        OntProperty p = model.createObjectProperty( NS+"p" );
        OntProperty q = model.createObjectProperty( NS+"q" );

        // 1. B or C
        OntClass b_or_c = model.createUnionClass( null, model.createList( new RDFNode[] { b, c } ));

        // 2. p only (B or C)
        OntClass p_only_b_or_c = model.createAllValuesFromRestriction( null, p, b_or_c );

        // 3. q exactly 1 C
        // OntClass q_exactly_1_C = model.createCardinalityQRestriction( null, q, 1, c );

        // 3a. q exactly 1
        OntClass q_exactly_1 = model.createCardinalityRestriction( null, q, 1 );

        // (2) and (3a)
        OntClass _2_and_3a = model.createIntersectionClass( null, model.createList( new RDFNode[] { p_only_b_or_c, q_exactly_1 } ));

        // a subClassOf ((p only (B or C)) and (q exactly 1))
        a.addSuperClass( _2_and_3a );

        model.write( System.out, "RDF/XML-ABBREV" );
    }
}