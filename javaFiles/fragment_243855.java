int i = 0;          
int c = 0;
for(Boolean b: bits){
    if (i > 0 && i % 8 == 0){
        out.append((char) c);
        c = 0;
    }
    c = (c << 1) | (b ? 1 : 0);
    i++;
}
out.append((char) c); // Not sure about the desired behaviour here