List<String> verb_hypernyms = wordnet.getHypernyms(verb, POS.VERB);
List<String> object_hypernyms = wordnet.getHypernyms(object, POS.NOUN);
List<String> subject_hypernyms = wordnet.getHypernyms(subject, POS.NOUN);


for(String verb_hypernym : verb_hypernyms)
    for(String object_hypernym : object_hypernyms)
        for(String subject_hypernym : subject_hypernyms)
            sentences.add(new Sentence(verb_hypernym, object_hypernym, subject_hypernym));

return sentences;