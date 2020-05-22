Pattern pattern = Pattern.compile("^\\(-?\\d+,-?\\d+\\)(\\s*,\\(-?\\d+,-?\\d+\\)){3}$");

// this will match
Matcher matcher = pattern.matcher("(8,0),(0,-1),(7,-2),(1,1)");
System.out.println("Matches: " + matcher.matches());

// this will not match
matcher = pattern.matcher("(8,0),(0,-1),(7,-2),(1,1");
System.out.println("Matches: " + matcher.matches());

// neither will this one, which has a dangling comma
matcher = pattern.matcher("(8,0),(0,-1),(7,-2),");
System.out.println("Matches: " + matcher.matches());

// neither will this one, which has too few order pairs
matcher = pattern.matcher("(8,0),(0,-1),(7,-2)");
System.out.println("Matches: " + matcher.matches());

// neither will this one, which has too many order pairs
matcher = pattern.matcher("(8,0),(0,-1),(7,-2),(1,1),(3,-5)");
System.out.println("Matches: " + matcher.matches());