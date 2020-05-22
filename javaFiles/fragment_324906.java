public static int[] counter (String s) {
    int [] countArr = new int[26];
    for(int i=0; i<s.length(); i++) {
        char charAtI = s.charAt(i);
        if(Character.isLetter(charAtI)) {
            countArr[Character.isUpperCase(charAtI) ? charAtI - 'A' : charAtI - 'a']++;
        }
    }
    return countArr;
}

public static void main (String[] args) {
    int [] countArr = counter("asif and abid.");
    for(int i = 0; i<countArr.length; i++) {
        if(countArr[i] > 0) {
            System.out.println(MessageFormat.format("{0} appears {1} times", (char)(i + 'a'), countArr[i]));
        }
    }
}