import java.io.File;
import gate.*;
import gate.creole.ConditionalSerialAnalyserController;
import gate.util.persistence.PersistenceManager;

public class CoreferencerTest {
    public static void main(String[] args) throws Exception {
        Gate.setGateHome(new File("C:\\Program Files\\GATE_Developer_8.4"));
        Gate.init();

        //load ANNIE GATE app
        Object gapp = PersistenceManager.loadObjectFromFile(
                new File(Gate.getPluginsHome(), "ANNIE/ANNIE_with_defaults.gapp"));
        ConditionalSerialAnalyserController pipelineController = (ConditionalSerialAnalyserController) gapp;

        //add Coreferencer to the end of ANNIE
        ProcessingResource coref = (ProcessingResource) Factory.createResource(
                "gate.creole.coref.Coreferencer", Utils.featureMap("resolveIt", true));
        pipelineController.add(coref);


        //execute it
        Corpus corpus = Factory.newCorpus("corpus name");
        Document doc = Factory.newDocument("Peter was driving his car.");
        corpus.add(doc);
        pipelineController.setCorpus(corpus);
        pipelineController.execute();

        //see the result
        System.err.println(doc.getFeatures().get("MatchesAnnots"));
    }
}