public static void main(String[] args){
    int[] abc = {2, 4, 8, 3};
    char[] phraseArray = {'a', 'b', 'c'};
    int add = 1;

    for (int i = 0; i < phraseArray.length; i++) {
            phraseArray[i] = (char) ((phraseArray[i] + (26+(-add%26)) - (int) 'a') % 26 + (int) 'a');
        System.out.println(phraseArray[i]);
    }

    return;
}