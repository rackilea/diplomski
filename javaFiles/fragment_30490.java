boolean found = false;
for(int i = 0; i < str.length; i++) {
    char c = str.charAt(i);
    if(c == ',' || c == '.' || c == '$') {
        found = true;
        break;
    }
}
if(!found) {
    /* Your commented-out code */
}