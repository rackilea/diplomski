ArrayList<String> out = new ArrayList<String>();
int i, last = 0;
int depth = 0;
for(i=0; i != string.length(); ++i) {
    if(string.charAt(i) == '<') ++depth;
    else if(string.charAt(i) == '>') { if(depth >0) --depth; }
    else if(string.charAt(i) == ' ' && depth == 0) {
        out.add(string.substring(last, i));
        last = i+1;
    }
}
if(last < string.length()) out.add(string.substring(last));