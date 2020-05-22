final String[] LETTER_A = {"  *  ", " * * ", "*****", "*   *", "*   *"};
final String[] LETTER_B = {"**** ", "*   *", "**** ", "*   *", "**** "};
// ...
final String[] LETTER_H = {"*   *", "*   *", "*****", "*   *", "*   *"};
// ...
final String[] LETTER_Y = {"*   *", " * * ", "  *  ", "  *  ", "  *  "};
final String[] LETTER_Z = {"*****", "   * ", "  *  ", " *   ", "*****"};

public void printASCII(String s) {
    for (String c : s.toUpperCase().split("")) {
        switch(c) {
            case "A":
                for (int i = 0; i < LETTER_A.length; i++) {
                    System.out.println(LETTER_A[i]);
                }
                System.out.println();
                break;
            case "B":
                for (int i = 0; i < LETTER_B.length; i++) {
                    System.out.println(LETTER_B[i]);
                }
                System.out.println();
                break;
            // ...
            case "H":
                for (int i = 0; i < LETTER_H.length; i++) {
                    System.out.println(LETTER_H[i]);
                }
                System.out.println();
                break;
            // ...
            case "Y":
                for (int i = 0; i < LETTER_Y.length; i++) {
                    System.out.println(LETTER_Y[i]);
                }
                System.out.println();
                break;
            case "Z":
                for (int i = 0; i < LETTER_Z.length; i++) {
                    System.out.println(LETTER_Z[i]);
                }
                System.out.println();
                break;
        }
    }
}