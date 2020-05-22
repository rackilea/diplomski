char out = (char)(in + shiftAmount);
if(out > 'z') {
   out = (char) ('a' + (out - 'z' - 1));
}
else if(out > 'Z' && out < 'a') {
   out = (char) ('A' + (out - 'Z' - 1));
}