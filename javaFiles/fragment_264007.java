Tree x = lp.apply("Christopher Manning owns club barcelona?");
TregexPattern NPpattern = TregexPattern.compile("@NP !<< @NP");
TregexMatcher matcher = NPpattern.matcher(x);
while (matcher.findNextMatchingNode()) {
  Tree match = matcher.getMatch();
  System.out.println(Sentence.listToString(match.yield()));
}