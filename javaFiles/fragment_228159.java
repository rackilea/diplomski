import java.io.InputStream;
 import org.apache.jena.ontology.*;
 import org.apache.jena.rdf.model.ModelFactory;
 import org.apache.jena.util.FileManager;

 public class ReadOntology {

    public OntModel model;

    public static void run(String ontologyInFile) {

        model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM_RULE_INF, null);
        InputStream ontologyIn = FileManager.get().open(ontologyInFile);

        loadModel(model, ontologyIn);
    }


    /** 
     * @param m
     * @param ontologyIn */
    protected static void loadModel(OntModel m, InputStream ontologyIn) {
        try {
             m.read(ontologyIn, "RDF/XML");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}