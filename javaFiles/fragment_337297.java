StringTokenizer t = new StringTokenizer(txt, " \t");
String date = t.nextToken();
t.nextToken(); // skip second date
t.nextToken(","); // change delimiter to comma and skip city
t.nextToken(" \t"); // back to whitespace and skip comma
String state = t.nextToken();