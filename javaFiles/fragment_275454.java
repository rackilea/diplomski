String markov(String input, List<Rule> rules) {

  // find the first matching rule, apply it and recurse 
  for (Rule rule : rules) {
    if (rule.matches(input)) {
      String temp = rule.apply(input);
      return markov(temp, rules);
    }
  }

  // no rule matched so just return the input text
  // - this is the terminating case for the recursion
  return input;
}