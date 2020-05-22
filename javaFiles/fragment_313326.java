import java.io.ByteArrayInputStream;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.vocabulary.VCARD;

public class RemoveStatementExample {
    public static void main(String[] args) {
        final String n3content = "" + 
                "@prefix rdf:     <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .\n" +
                "@prefix vCard:   <http://www.w3.org/2001/vcard-rdf/3.0#> .\n" +
                "<http://somewhere/JohnSmith/>\n" +
                "  vCard:FN \"John Smith\" ;\n" +
                "  vCard:N [ vCard:Family \"Smith\" ;\n" +
                "            vCard:Given \"John\"\n" +
                "          ] .\n" +
                "";
        final Model model = ModelFactory.createDefaultModel()
                            .read( new ByteArrayInputStream( n3content.getBytes()), null, "N3" );

        // before removal
        System.out.println( "== before removal ==" );
        model.write( System.out, "N3" );

        // remove the statement.  Note that in your data, "John Smith" is an 
        // *untyped* literal, so we use createLiteral( "John Smith" ) rather than
        // createTypedLiteral( "John Smith" ).
        model.remove( model.createResource( "http://somewhere/JohnSmith/" ),
                      VCARD.FN,
                      model.createLiteral( "John Smith" ));

        System.out.println( "\n\n== after removal ==" );
        model.write( System.out, "N3" );
    }
}