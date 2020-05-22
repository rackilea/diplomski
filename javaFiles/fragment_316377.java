QuestionDTO questionDTO = new QuestionDTO ();
HashMap<String, QuestionDTO > nodes = new HashMap<>();
nodes.put("foo", QuestionDTO );
Rule rule = new Rule("my rule", nodes);
rule= ruleRepository.save(rule);  //Note the variable re-assignement
String id = rule.getId();