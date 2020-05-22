import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import opennlp.addons.modelbuilder.DefaultModelBuilderUtil;
import opennlp.tools.entitylinker.EntityLinkerProperties;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

public class ModelBuilderAddonUse {
//fill this method in with however you are going to get your data into a list of sentences..for me I am hitting a MySQL database
  private static List<String> getSentencesFromSomewhere() throws Exception {
    List<String> sentences = new ArrayList<>();
    int counter = 0;
    DocProvider dp = new DocProvider();
    String modelPath = "c:\\apache\\entitylinker\\";
    EntityLinkerProperties properties = new EntityLinkerProperties(new File(modelPath + "entitylinker.properties"));
    Map<Long, List<String>> docs = dp.getDocs(properties);
    for (Long key : docs.keySet()) {
      counter++;
      System.out.println("\t\tDOC: " + key + "\n\n");
      String docu = "";
      sentences.addAll(docs.get(key));
      counter++;
      if(counter > 1000){
        break;
      }
    }
    return sentences;
  }

  public static void main(String[] args) throws Exception {
    /**
     * establish a file to put sentences in
     */
    File sentences = new File("C:\\temp\\modelbuilder\\sentences.text");

    /**
     * establish a file to put your NER hits in (the ones you want to keep based
     * on prob)
     */
    File knownEntities = new File("C:\\temp\\modelbuilder\\knownentities.txt");

    /**
     * establish a BLACKLIST file to put your bad NER hits in (also can be based
     * on prob)
     */
    File blacklistedentities = new File("C:\\temp\\modelbuilder\\blentities.txt");

    /**
     * establish a file to write your annotated sentences to
     */
    File annotatedSentences = new File("C:\\temp\\modelbuilder\\annotatedSentences.txt");

    /**
     * establish a file to write your model to
     */
    File theModel = new File("C:\\temp\\modelbuilder\\theModel");


//------------create a bunch of file writers to write your results and sentences to a file

    FileWriter sentenceWriter = new FileWriter(sentences, true);
    FileWriter blacklistWriter = new FileWriter(blacklistedentities, true);
    FileWriter knownEntityWriter = new FileWriter(knownEntities, true);

//set some thresholds to decide where to write hits, you don't have to use these at all...
    double keeperThresh = .95;
    double blacklistThresh = .7;


    /**
     * Load your model as normal
     */
    TokenNameFinderModel personModel = new TokenNameFinderModel(new File("c:\\temp\\opennlpmodels\\en-ner-person.zip"));
    NameFinderME personFinder = new NameFinderME(personModel);
    /**
     * do your normal NER on the sentences you have
     */
    for (String s : getSentencesFromSomewhere()) {
      sentenceWriter.write(s.trim() + "\n");
      sentenceWriter.flush();

      String[] tokens = s.split(" ");//better to use a tokenizer really
      Span[] find = personFinder.find(tokens);
      double[] probs = personFinder.probs();
      String[] names = Span.spansToStrings(find, tokens);
      for (int i = 0; i < names.length; i++) {
        //YOU PROBABLY HAVE BETTER HEURISTICS THAN THIS TO MAKE SURE YOU GET GOOD HITS OUT OF THE DEFAULT MODEL
        if (probs[i] > keeperThresh) {
          knownEntityWriter.write(names[i].trim() + "\n");
        }
        if (probs[i] < blacklistThresh) {
          blacklistWriter.write(names[i].trim() + "\n");
        }
      }
      personFinder.clearAdaptiveData();
      blacklistWriter.flush();
      knownEntityWriter.flush();
    }
    //flush and close all the writers
    knownEntityWriter.flush();
    knownEntityWriter.close();
    sentenceWriter.flush();
    sentenceWriter.close();
    blacklistWriter.flush();
    blacklistWriter.close();

    /**
     * THIS IS WHERE THE ADDON IS GOING TO USE THE FILES (AS IS) TO CREATE A NEW MODEL. YOU SHOULD NOT HAVE TO RUN THE FIRST PART AGAIN AFTER THIS RUNS, JUST NOW PLAY WITH THE
     * KNOWN ENTITIES AND BLACKLIST FILES AND RUN THE METHOD BELOW AGAIN UNTIL YOU GET SOME DECENT RESULTS (A DECENT MODEL OUT OF IT).
     */
    DefaultModelBuilderUtil.generateModel(sentences, knownEntities, blacklistedentities,
            theModel, annotatedSentences, "person", 3);


  }
}