import java.util.*;

import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.ling.CoreAnnotations.*;

Properties props = new Properties();

props.put("annotators", "tokenize, ssplit, pos, lemma");
pipeline = new StanfordCoreNLP(props, false);
String text = "Hello, world!";
Annotation document = pipeline.process(text);

for(CoreMap sentence: document.get(SentencesAnnotation.class)) {
    for(CoreLabel token: sentence.get(TokensAnnotation.class)) {
        String word = token.get(TextAnnotation.class);
        String lemma = token.get(LemmaAnnotation.class);
    }
}