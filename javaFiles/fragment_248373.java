# these Java classes will be used by the rules
ner = { type: "CLASS", value: "edu.stanford.nlp.ling.CoreAnnotations$NamedEntityTagAnnotation" }
tokens = { type: "CLASS", value: "edu.stanford.nlp.ling.CoreAnnotations$TokensAnnotation" }

# rule for recognizing compound names
{ ruleType: "tokens", pattern: ([{tag:"NN"}] [{tag:"IN"}] [{tag:"DT"}] [{tag:"NNP"}]), action: Annotate($0, ner, "COMPOUND"), result: "COMPOUND_RESULT" }