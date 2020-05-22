import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.xml.parsers.DocumentBuilderFactory;

@Dependent
public class DocumentBuilderFactoryProducer {
    @Produces
    @ApplicationScoped
    public DocumentBuilderFactory createDocumentBuilderFactory() {
        DocumentBuilderFactory result = DocumentBuilderFactory.newInstance();
        result.setNamespaceAware(true);
        // other customizations ...
        return result;
    }
}