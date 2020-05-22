String sampleFrenchText = "Le chat mange la souris";
Annotation frenchAnnotation = new Annotation(sampleFrenchText);
Properties frenchProperties = StringUtils.argsToProperties(new String[]{"-props", "StanfordCoreNLP-french.properties"});
StanfordCoreNLP pipeline = new StanfordCoreNLP(frenchProperties);
pipeline.annotate(frenchAnnotation);
for (CoreMap sentence : frenchAnnotation.get(CoreAnnotations.SentencesAnnotation.class)) {
    Tree sentenceTree = sentence.get(TreeCoreAnnotations.TreeAnnotation.class);
    System.out.println(sentenceTree);
}