String s = "Magic_Carpet_Ride";

s.startsWith("Magic");   // non-regex
s.matches("Magic.*");    // regex

s.contains("Carpet");    // non-regex
s.matches(".*Carpet.*"); // regex

s.endsWith("Ride");      // non-regex
s.matches(".*Ride");     // regex