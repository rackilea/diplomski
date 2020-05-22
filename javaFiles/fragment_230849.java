package edu.stanford.nlp.examples;

import edu.stanford.nlp.util.*;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.pipeline.*;

import java.util.*;


public class TokensRegexExampleTwo {

  public static void main(String[] args) {

    // set up properties
    Properties props = new Properties();
    props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,tokensregex");
    props.setProperty("tokensregex.rules", "this-should-match.rules");
    props.setProperty("tokensregex.caseInsensitive", "true");

    // set up pipeline
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

    // set up text to annotate
    Annotation annotation = new Annotation("This should match.");

    // annotate text
    pipeline.annotate(annotation);

    // print out found entities
    for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
      for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
        System.out.println(token.word() + "\t" +
            token.get(edu.stanford.nlp.ling.CoreAnnotations.GoldAnswerAnnotation.class));
      }
    }
  }
}