ITokenScanner scanner = new RuleBasedScanner();
IToken string = createToken(colorString);    
IRule[] rules = new IRule[3];    
// Add rule for double quotes  
rules[0] = new SingleLineRule("\"", "\"", string, '\\');  
// Add a rule for single quotes   
rules[1] = new SingleLineRule("'", "'", string, '\\');   
// Add generic whitespace rule.    
rules[2] = new WhitespaceRule(whitespaceDetector);  
scanner.setRules(rules);  
scanner.setDefaultReturnToken(createToken(colorTag));