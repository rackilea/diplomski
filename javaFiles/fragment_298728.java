public String solve(String input) {
    String ret = "";
    int pos = 0;

    while(pos<input.length()) {
        // find next position of space
        int next = input.indexOf(' ',pos);

        // space not exists, skip next to end of string
        if(next==-1) next = input.length();

        // take 1 word from input
        String word = input.substring(pos,next);

        // check if word exists in previous result
        if(ret.indexOf(word)==-1) {
            if(ret.length() > 0) ret += " ";
            // append word to ret
            ret += word;
        }
        pos = next + 1;
    }
    return ret;
}