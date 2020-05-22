String stringReplace(String str, List<Replacement> replacements){

    // Sort Replacements in reverse order by index 
    Collections.sort(replacements, new Comparator<Replacement>(){
        @Override public int compare(Replacement r1, Replacement r2){
            return -Integer.compare(r1.s, r2.s);  // Note reverse order
        }
    };

    // By replacing in reverse order, shouldn't affect next replacement.
    StringBuilder sb = new StringBuilder(str);
    for(Replacement rep : replacements){
        sb.replace(rep.s, rep.e, rep.str);
    }

    return sb.toString();
}