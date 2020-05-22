import org.semanticweb.HermiT.ReasonerFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.io.File;

public class LoadDBPedia {

    private static Logger logger = LoggerFactory.getLogger(LoadDBPedia.class);
    // Why This Failure marker
    private static final Marker WTF_MARKER = MarkerFactory.getMarker("WTF");

    private static String ONTOLOGY_FILE = "/path_to_ontology/dbpedia_2016-10.owl";

    public static void main(String[] args) {
        try {
            File file = new File(ONTOLOGY_FILE);
            if (file.exists()) {
                OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
                OWLOntology ontology = manager.loadOntologyFromOntologyDocument(file);

                OWLReasonerFactory reasonerFactory = new ReasonerFactory();
                OWLReasoner reasoner = reasonerFactory.createReasoner(ontology);
                if (!reasoner.isConsistent()) {
                    logger.debug("Ontology is inconsistent");
                    throw new Exception("Ontology is inconsistent");
                } else {
                    logger.debug("Ontology is consistent");
                }
              }

            } catch (Throwable t) {
            logger.error(WTF_MARKER, t.getMessage(), t);
        }
    }
 }