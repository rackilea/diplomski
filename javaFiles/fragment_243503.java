import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFactory;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class QuerySolutionsFromIndicesExample {

    final static String modelText = "" +
            "@prefix bio: <http://www.semanticweb.org/vassilis/ontologies/2013/5/Onto#>.\n" +
            "@prefix ex: <http://example.org/>.\n" +
            "\n" +
            "ex:Giraffe a bio:Animal .\n" +
            "ex:Dog a bio:Animal .\n" +
            "ex:Cat a bio:Animal . \n" +
            "ex:WoollyMammoth a bio:Animal.\n" +
            "";

    final static String sparqlQuery = "" +
            "prefix bio: <http://www.semanticweb.org/vassilis/ontologies/2013/5/Onto#>\n" +
            "\n" +
            "select ?animal where {\n" +
            "  ?animal a bio:Animal\n" +
            "}\n" +
            "";

    public static void main(String[] args) {
        final Model model = ModelFactory.createDefaultModel();
        model.read( new ByteArrayInputStream( modelText.getBytes()), null, "TTL" );

        final ResultSet results = ResultSetFactory.copyResults( QueryExecutionFactory.create( sparqlQuery, model ).execSelect() );

        System.out.println( "== All Solutions ==" );
        ResultSetFormatter.out( results );

        // based on https://stackoverflow.com/q/10565335/1281433
        final String input = "0,3"; 
        final String[] indices = input.split("\\s*,\\s*");

        final List<QuerySolution> selectedSolutions = new ArrayList<QuerySolution>( indices.length ) {{
            final List<QuerySolution> solutions = ResultSetFormatter.toList( results );
            for ( final String index : indices ) {
                add( solutions.get( Integer.valueOf( index )));
            }
        }};

        System.out.println( "== Selected Solutions ==" );
        System.out.println( selectedSolutions );
    }
}