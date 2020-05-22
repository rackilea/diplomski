public NamedEntityRecognition() {
    Properties props = new Properties();
    props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,entitylink");
    props.setProperty("ner.additional.tokensregex.rules", "extended_ner.rules");

    props.setProperty("tokenize.options", "untokenizable=noneDelete");

    pipeline = new StanfordCoreNLP(props);
  }