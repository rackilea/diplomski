private static void countAllChars() {
    for (int i = 0; i < alphabetArray.length; i++) {
        if(alphabetArray[i]>0) {
            char ch = (char) (i+97);
            System.out.print(ch +"="+alphabetArray[i]+ " ");
        }
    }
}