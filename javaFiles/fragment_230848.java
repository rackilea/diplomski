ruleClass = { type: "CLASS", value: "edu.stanford.nlp.ling.CoreAnnotations$GoldAnswerAnnotation" }

{
   "pattern": ( /This/ /should/ /match/ ),
   "action": ( Annotate($0, ruleClass, "this should match!") ),
   "result": "This is the result!"
}