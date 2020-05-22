import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;

public class SPARQLJOptions {

    /**
     * Content for a model
     */
    final static String modelContent = "" +
            "@prefix : <http://example.org/>.\n" +
            ":a :p :b, :c, :d .\n" +
            ":b :p :c, :a .\n" +
            "";

    /** 
     * A query to run against the model (will return b, c, and d).
     */
    final static String query = "" +
            "prefix : <http://example.org/> \n" +
            "select ?value where { \n" +
            " :a :p ?value \n" +
            "}" +
            "";

    public static void main(String[] args) {
        // Create a model and read in the model contents
        final Model model = ModelFactory.createDefaultModel();
        model.read( new ByteArrayInputStream( modelContent.getBytes()), null, "TTL" );

        // Run the query and copy the values of ?value into an List<Object>
        final ResultSet results = QueryExecutionFactory.create( query, model ).execSelect();
        List<Object> values = new ArrayList<Object>();
        while ( results.hasNext() ) {
            values.add( results.next().get( "value" ));
        }

        // Show an input dialog whose options are the elements in the list and
        // whose default selection is the first element of the list.
        Resource choice = (Resource) JOptionPane.showInputDialog(
                null,                           // no container window
                "Select a resource",
                "Selecting Resource...",
                JOptionPane.QUESTION_MESSAGE,
                null,                           // no Icon
                values.toArray(),
                values.get(0));

        System.out.println( choice );
    }
}