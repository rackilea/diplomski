Input: 
  19951010 19951011 Red City, WI Description

Your components:
  String re1="(\\d+)";    // Integer Number 1
  String re2=".*?";   // Non-greedy match on filler
  String re3="(?:[a-z][a-z]+)";   // Uninteresting: word
  String re4=".*?";   // Non-greedy match on filler
  String re5="(?:[a-z][a-z]+)";   // Uninteresting: word
  String re6=".*?";   // Non-greedy match on filler
  String re7="((?:[a-z][a-z]+))"; // Word 1

What they match:
  re1: "19951010"
  re2: " 19951011 "
  re3: "Red" (stops at non-letter, e.g. whitespace)
  re4: " "
  re5: "City" (stops at non-letter, e.g. the comma)
  re6: ", " (stops at word character)
  re7: "WI"