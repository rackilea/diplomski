BNDMWildcards bndm = new BNDMWildcards();
int bndmIdx = 0;
int stopIdx = text.length();
boolean isFound = false;

while(!isFound && (bndmIdx = bndm.searchString(text, bndmIdx, stopIdx, "."+key+".")) != -1){
    char[] textChars = text.toCharArray();
    if(Character.isWhitespace(textChars[bndmIdx]) && Character.isWhitespace(textChars[bndmIdx+key.length()+1])){
        System.out.println("BNDM: Match");
        isFound = true;
    }
}
if(!isFound)
    System.out.println("BNDM: No match");