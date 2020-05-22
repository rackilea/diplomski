String sentencel=sentence.toLowerCase();
char[] letters;
letters=new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
int numDiffLetters=0;
for(int i=0; i<sentencel.length(); i++){
    for(int j=0; j<letters.length; j++){
        if(sentencel.charAt(i)==letters[j]){
            letters[j]='0';
            break;
        }
    }
}
for(int i=0; i<letters.length; i++){
    if(letters[i]=='0'){
        numDiffLetters++;
    }
}