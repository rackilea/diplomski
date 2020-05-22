int len;
if (s == null) {
    len = 0;
}
else {
    len = s.length();  // safe, s is never null when you get here
}