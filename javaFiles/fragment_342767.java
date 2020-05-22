// load the models outside your loop
InputStream inputStream =
    new FileInputStream("/home/bruno/openNLP/apache-opennlp-1.7.2-src/models/pt-sent.bin");
SentenceModel model = new SentenceModel(inputStream);

//Instantiating the SentenceDetectorME class 
SentenceDetectorME detector = new SentenceDetectorME(model);

InputStream inputStreamTokenizer =
    new FileInputStream("/home/bruno/openNLP/apache-opennlp-1.7.2-src/models/pt-token.bin");
TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer);
//Instantiating the TokenizerME class 
TokenizerME tokenizer = new TokenizerME(tokenModel);


//Loading the NER-person model 
InputStream inputStreamNameFinder = new FileInputStream("/home/bruno/TryOllie/data/pt-ner-floresta.bin");
TokenNameFinderModel model2 = new TokenNameFinderModel(inputStreamNameFinder);

//Instantiating the NameFinderME class 
NameFinderME nameFinder2 = new NameFinderME(model2);

String line = input.nextLine();

while(line != null) {

  // first we find sentences
  String sentences[] = detector.sentDetect(line);

  for (String sentence :
      sentences) {
    // now we find the sentence tokens
    String tokens[] = tokenizer.tokenize(sentence);

    // now we are good to apply NER
    Span[] nameSpans = nameFinder2.find(tokens);

    // now we can print the spans
    System.out.println(Arrays.toString(Span.spansToStrings(nameSpans, tokens)));

    line = input.nextLine();
  }
}