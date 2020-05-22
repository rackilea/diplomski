import edu.stanford.nlp.hcoref.CorefCoreAnnotations;
import edu.stanford.nlp.hcoref.data.CorefChain;
import edu.stanford.nlp.hcoref.data.Mention;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.util.*;

public class CorefExample {

    public static void main(String[] args) throws Exception {

        Annotation document = new Annotation("John Kerry is the secretary of state.  He ran for president in 2004.");
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,mention,coref");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        pipeline.annotate(document);
        System.out.println("---");
        System.out.println("coref chains");
        for (CorefChain cc : document.get(CorefCoreAnnotations.CorefChainAnnotation.class).values()) {
            System.out.println("\t"+cc);
            System.out.println(cc.getMentionMap());
            List<CorefChain.CorefMention> corefMentions = cc.getMentionsInTextualOrder();
            for (CorefChain.CorefMention cm : corefMentions) {
                System.out.println("---");
                System.out.println("full text: "+cm.mentionSpan);
                System.out.println("position: "+cm.position);
                System.out.println("start index of first word: "+cm.startIndex);
            }
        }
        for (CoreMap sentence : document.get(CoreAnnotations.SentencesAnnotation.class)) {
            System.out.println("---");
            System.out.println("mentions");
            for (Mention m : sentence.get(CorefCoreAnnotations.CorefMentionsAnnotation.class)) {
                System.out.println("\t"+m);
            }
        }
    }
}