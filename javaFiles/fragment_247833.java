import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

public class PrefixDemo {
  public static void main(String[] args) {
    Model model = ModelFactory.createDefaultModel();
    String base = "http://www.something.com/";

    Resource john = model.createResource( base + "John" );
    Property hasSurname = model.createProperty( base + "hasSurname" );

    model.add( john, hasSurname, "Smith" );

    // Before defining a prefix
    model.write( System.out, "RDF/XML" );

    // After defining a prefix
    model.setNsPrefix( "something", base );
    model.write( System.out, "RDF/XML" );
  }
}