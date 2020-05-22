String re1 = "(\\d+)";   // match first number
String re2 = "[^,]*";    // skip everything thats not a comma
String re3 = ",";        // skip the comma
String re4 = "[\\s]*";   // skip whitespace
String re5 = "([a-z]+)"; // match letters (state)

String regex = re1 + re2 + re3 + re4 + re5;