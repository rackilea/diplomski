import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class AppendSPARQLQueryResults {
    public static void main(String[] args) {
        // This is the model that we'll store all the results in. We'll
        // add some prefixes just to make the output a little nicer.
        Model results = ModelFactory.createDefaultModel();
        results.setNsPrefix( "dbpedia", "http://dbpedia.org/resource/" );
        results.setNsPrefix( "dbpedia-owl", "http://dbpedia.org/ontology/" );
        results.setNsPrefix( "schema", "http://schema.org/" );

        // Two queries to run
        String[] queries = {
                "construct where { <http://dbpedia.org/resource/Mount_Monadnock> a ?type } limit 5",
                "construct where { <http://dbpedia.org/resource/Mount_Monadnock> <http://dbpedia.org/ontology/locatedInArea> ?place } limit 5" 
        };

        // Run each query, then show its individual results, and add
        // them to the combined model
        for ( String query : queries ) {
            Model result = QueryExecutionFactory.sparqlService( "http://dbpedia.org/sparql", query ).execConstruct();
            System.out.println( "\n<!-- results of: " +query+" -->" );
            result.write( System.out, "RDF/XML-ABBREV" );
            results.add( result );
        }

        // Show the combined results
        System.out.println( "\n<!-- combined results -->" );
        results.write( System.out, "RDF/XML-ABBREV" );
    }
}