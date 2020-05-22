public Keypad(String chars, int rowLength) {
        // you don't need to count the length with a loop
        int nRow = chars.length()/rowLength;
        if(chars.length()%rowLength!=0) nRow++;
        letters = new char[nRow][rowLength];

        for(int i = 0, n = 0 ; i < letters.length ; i++) {
            for(int j = 0 ; n < chars.length() && j < letters[i].length ; j++, n++) {
                letters[i][j] = chars.charAt(n);
            }
        }
    }