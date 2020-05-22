// If the last ) might not be the last character of the String
String s = "Your String with) multiple).";
StringBuilder sb = new StringBuilder(s);
sb.deleteCharAt(s.lastIndexOf(')'));
s = sb.toString(); // s = "Your String with) multiple."

// If the last ) will always be the last character of the String
s = "Your String with))";
if (s.endsWith(")")) 
    s = s.substring(0, s.length() - 1);
// s = "Your String with)"