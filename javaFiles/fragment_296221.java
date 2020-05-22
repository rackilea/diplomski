XMLLexicon lexicon = ...
NLGFactory phraseFactory = new NLGFactory(lexicon);
VPPhraseSpec live = phraseFactory.createVerbPhrase("live");
SPhraseSpec clause = phraseFactory.createClause();
clause.setVerbPhrase(live);
clause.setFeature(Feature.FORM, Form.GERUND);
Realizer realizer = new Realizer(lexicon);
String gerund = realizer.realize(clause).getRealisation();