/** This class represents a replacement of characters in the original String, s[i0:if], 
  *  with a new string, str. 
 **/
class Replacement{
    int s, e;
    String str;
    public Replacement(int s, int e, String str){ 
        this.s = s;
        this.e = e;
        this.str = str;
    }
}

String stringReplace(String str, List<Replacement> replacements){

    // Sort Replacements by starting index
    Collections.sort(replacements, new Comparator<Replacement>(){
        @Override public int compare(Replacement r1, Replacement r2){
            return Integer.compare(r1.s, r2.s);
        }
    };

    StringBuilder sb = new StringBuilder();
    int repPos = 0;

    for(int i = 0; i < str.length; i++){
        Replacement rep = replacements.get(repPos);
        if(rep.s == i){               // Replacement starts here, at i == s
            sb.append(rep.str);       // Append the replacement
            i = rep.e - 1;            // Advance i -> e - 1
            repPos++;                 // Advance repPos by 1
        } else {
            sb.append(str.charAt(i)); // No replacement, append char
        }
    }

    return sb.toString();
}