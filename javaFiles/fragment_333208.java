import java.io.ByteArrayInputStream;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.vocabulary.VCARD;

public class PropertySubjectsExample {
    static String CONTENT = "\n" +
            "@prefix xsd:   <http://www.w3.org/2001/XMLSchema#> .\n" +
            "@prefix vcard: <http://www.w3.org/2001/vcard-rdf/3.0#> .\n" +
            "@prefix : <http://stackoverflow.com/q/23161586/1281433/>\n" +
            "\n" +
            ":x vcard:EMAIL \"visittoravi@gmail.com\"^^xsd:string .\n" +
            "";

    public static void main(String[] args) {
        Model model = ModelFactory.createDefaultModel();
        model.read( new ByteArrayInputStream( CONTENT.getBytes()), null, "TTL" );
        ResIterator subjects = model.listSubjectsWithProperty(
                                    VCARD.EMAIL,
                                    model.createTypedLiteral( "visittoravi@gmail.com" ));
        while ( subjects.hasNext() ) {
            System.out.println( subjects.next() );
        }
    }
}