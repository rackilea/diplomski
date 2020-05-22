import gate.*;
import gate.creole.SerialAnalyserController;
import java.io.File;
import java.util.*;

public class Segmenter {
    public static void main(String[] args) throws Exception {
        Gate.setGateHome(new File("C:\\Program Files\\GATE_Developer_8.0"));
        Gate.init();
        regiterGatePlugin("ANNIE");

        SerialAnalyserController pipeline = (SerialAnalyserController) Factory.createResource("gate.creole.SerialAnalyserController");
        pipeline.add((ProcessingResource) Factory.createResource("gate.creole.tokeniser.DefaultTokeniser"));
        pipeline.add((ProcessingResource) Factory.createResource("gate.creole.splitter.SentenceSplitter"));

        Corpus corpus = Factory.newCorpus("SegmenterCorpus");
        Document document = Factory.newDocument("Text to be segmented.");
        corpus.add(document); 
        pipeline.setCorpus(corpus); 
        pipeline.execute();

        AnnotationSet defaultAS = document.getAnnotations();
        AnnotationSet sentences = defaultAS.get("Sentence");

        for (Annotation sentence : sentences) {
            System.err.println(Utils.stringFor(document, sentence));
        }

        //Clean up
        Factory.deleteResource(document);
        Factory.deleteResource(corpus);
        for (ProcessingResource pr : pipeline.getPRs()) {
            Factory.deleteResource(pr);
        }
        Factory.deleteResource(pipeline);
    }

    public static void regiterGatePlugin(String name) throws Exception {
        Gate.getCreoleRegister().registerDirectories(new File(Gate.getPluginsHome(), name).toURI().toURL());
    }
}