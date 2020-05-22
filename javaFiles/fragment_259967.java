public static void main(String[] args){
    char[] phraseArray = {'a', 'b', 'c'};
    int add = -1;

    for (int i = 0; i < phraseArray.length; i++) {
        if(add>=0) {
            phraseArray[i] = (char) ((phraseArray[i] + add - (int) 'a') % 26 + (int) 'a');
        }else{
            phraseArray[i] = (char) ((phraseArray[i] + (26+(add%26)) - (int) 'a') % 26 + (int) 'a');
        }
        System.out.println(phraseArray[i]);
    }

    return;
}