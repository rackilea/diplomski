int counter =0;
for(int i=0;i!=-1;) {
    i=val.indexOf("*");
    if(counter%2==0) {
        val = val.replaceFirst("\\*","<b>");
    } else {
        val = val.replaceFirst("\\*","<\\\\b>");
    }
    counter++;
}