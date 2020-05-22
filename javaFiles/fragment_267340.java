import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.sparql.core.Var;
import com.hp.hpl.jena.sparql.syntax.ElementGroup;

public class AddTriplePattern {
    public static void main(String[] args) {
        // Create the original query
        final String queryString = "" +
                "select * where {\n" +
                "  ?s ?p ?o .\n" +
                "}\n" +
                "";
        final Query query = QueryFactory.create( queryString );

        // Create the new query and add `?s2 ?p2 ?o2`. Print the new query
        // before and after adding the triple pattern.  Sure enough, after 
        // the modification, the pattern is printed without a `.` between the 
        // triples.  The space between the variables is also a bit bigger.
        final Query newQuery = QueryFactory.create( query );
        System.out.println( "== before ==\n"+newQuery );
        final ElementGroup eg = (ElementGroup) newQuery.getQueryPattern();
        final Triple t = new Triple( Var.alloc( "s2"), Var.alloc( "p2" ), Var.alloc( "o2" ));
        eg.addTriplePattern( t );
        newQuery.setQueryResultStar(false);
        newQuery.addResultVar( "s2" );
        System.out.println( "== after ==\n"+newQuery );

        // Create a model with a single triple [a, a, a].
        final Model model = ModelFactory.createDefaultModel();
        final Resource a = model.createResource( "urn:ex:a" );
        model.add( a, a.as( Property.class ), a );

        // Run both the original query and the new query on the model.  Both
        // return the expected results.
        ResultSetFormatter.out( QueryExecutionFactory.create( query, model ).execSelect() );
        ResultSetFormatter.out( QueryExecutionFactory.create( newQuery, model ).execSelect() );
    }
}