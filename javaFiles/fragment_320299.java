String calcExpression = "a";
String useFor = "b";

String query = String.format(FORMAT, WILDCARD, calcExpression, WILDCARD, 
    WILDCARD, useFor, WILDCARD);
System.out.println(query);