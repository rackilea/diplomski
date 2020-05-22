int ls = search.length();  // length of initial string
StringBuilder sb = new StringBuilder(); // temporary place to store growing string
for(int ii=ls-1;ii>=0; ii--) {
        sb.append(search.charAt(ii)); // build the string one character at a time
    }
hcraes = sb.toString(); // convert to "regular" string