public boolean isInAlphabet(String inputString) {
    if(inputString==null || inputString.length()==0) return false;
    if(inputString.charAt(0)!=inputString.charAt(inputString.length()-1)) return false;
    for(char ch:inputString.toCharArray()){
        if(!alphabet.contains(ch)) return false;
    }
    return true;
}