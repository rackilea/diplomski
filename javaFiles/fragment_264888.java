public void getComb(String line) {
    String words[] = line.split(" ");

    for (int i = 0; i < words.length; i++) {
        int count = 0;   // RESET COUNT
        String word = "";
        int m = i;
        while (count < 5 && m < words.length) { // NO EXCEPTION with 'm' limit
            count++;
            word += " " + words[m];
            System.out.println(word);
            m++;
        }
    }
}