public static char [] [] rightDiagonal(char starParam, int dimenParam) {
        char [] [] rightD = new char [dimenParam] [dimenParam];

        for (int i = 0; i < dimenParam; i++){
            for (int j = 0; j < dimenParam; j++) {
                rightD[i][j] = ' ';
// I fill all the element spaces with blanks first then put in the *
// If there's another way to do It I'd like to know
            }
        }

        for (int i = 0; i < dimenParam; i++){
            for (int j = rightD.length-1; j >= 0; j--) {
                if(i + j == rightD.length - 1) {
                    rightD[i][j] = starParam;
                } else {
                    rightD[i][j] = ' ';
                }
            }
        }
        return rightD;
    }