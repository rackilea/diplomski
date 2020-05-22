String g = "abc";
String h = "dagb";
for(int j = 0; j < g.length();j++){
    char c = g.charAt(j);
    h = h.replace(c,'Q');
}