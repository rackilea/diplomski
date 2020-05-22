List<Sentence> sentences = new ArrayList<>();

for(String verb_hypernym : wordnet.getHypernyms(verb, POS.VERB))
    for(String object_hypernym : wordnet.getHypernyms(object, POS.NOUN))
        for(String subject_hypernym : wordnet.getHypernyms(subject, POS.NOUN))
            sentences.add(new Sentence(verb_hypernym, object_hypernym, subject_hypernym));

return sentences;