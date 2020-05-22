StringBuilder sb = new StringBuilder();

for (int i = 0; i < str.length(); i = i+1) {
    char ch = str.charAt(i);
    if (ch > 127) {
        // TODO: generate all the \\""+; crap around CHR$()
        sb.append(String.format("CHR$(%d)", (int)ch));
    }
    else 
        sb.append ch;
}