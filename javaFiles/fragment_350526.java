public boolean myContains(String s1, String s2){
    if(s1 == null || s2 == null)
        return false;
    if(s1.isEmpty() || s2.isEmpty())
        return false;
    if(s2.startsWith(s1))
        return true;
    return myContains(s1, s2.substring(1));
}