int len = s.length();
// Log or print value of `len`
String sub = s.substring(len - 1);
// Log or print value of `sub`
boolean endsSemiColon = sub.equals(";");
// Log or print value of `endsSemiColon`
if(!endsSemiColon) {
    s = s + ";";
}