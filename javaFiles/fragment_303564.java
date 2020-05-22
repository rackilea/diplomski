public char rot13(char s){
    if (c >= 'a' && c <= 'm') return c += 13;
    else if  (c >= 'A' && c <= 'M') return c += 13;
    else if  (c >= 'n' && c <= 'z') return c -= 13;
    else if  (c >= 'N' && c <= 'Z') return c -= 13;
    else return c;
}