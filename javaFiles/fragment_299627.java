import java.io.*;
import java.util.*;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.semgraph.*;
import edu.stanford.nlp.util.*;



public class NERAndVerbExample {

  public static void main(String[] args) throws IOException {
    Properties props = new Properties();
    props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,depparse,entitymentions");
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
    String text = "John Smith went to the store.";
    Annotation annotation = new Annotation(text);
    pipeline.annotate(annotation);
    System.out.println("---");
    System.out.println("text: " + text);
    System.out.println("");
    System.out.println("dependency edges:");
    for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
      SemanticGraph sg = sentence.get(SemanticGraphCoreAnnotations.CollapsedDependenciesAnnotation.class);
      for (SemanticGraphEdge sge : sg.edgeListSorted()) {
        System.out.println(
                sge.getGovernor().word() + "," + sge.getGovernor().index() + "," + sge.getGovernor().tag() + "," +
                        sge.getGovernor().ner()
                        + " - " + sge.getRelation().getLongName()
                        + " -> "
                        + sge.getDependent().word() + "," +
                        +sge.getDependent().index() + "," + sge.getDependent().tag() + "," + sge.getDependent().ner());
      }
      System.out.println();
      System.out.println("entity mentions:");
      for (CoreMap entityMention : sentence.get(CoreAnnotations.MentionsAnnotation.class)) {
        int lastTokenIndex = entityMention.get(CoreAnnotations.TokensAnnotation.class).size()-1;
        System.out.println(entityMention.get(CoreAnnotations.TextAnnotation.class) +
                "\t" +
                entityMention.get(CoreAnnotations.TokensAnnotation.class)
                        .get(lastTokenIndex).get(CoreAnnotations.IndexAnnotation.class) + "\t" +
                entityMention.get(CoreAnnotations.NamedEntityTagAnnotation.class));
      }
    }
  }
}