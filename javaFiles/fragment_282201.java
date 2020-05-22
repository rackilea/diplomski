public static void main(String[] args) {
        String[] spots0 = { "A1", "B1", "C1", "D1" };
        String[] spots1 = { "A1", "A2", "A3", "A4" };
        String[] spots2 = { "A1", "B1", "B2", "B3" };

        System.out.println(isCorrect(spots0) ? "correct" : "incorrect");
        System.out.println(isCorrect(spots1) ? "correct" : "incorrect");
        System.out.println(isCorrect(spots2) ? "correct" : "incorrect");
    }

    public static boolean isCorrect(String[] spots) {
        int NONE = -1;
        int HORIZONTAL = 1;
        int VERTICAL = 2;

        int pattern = NONE; //BY DEFAULT NONE

        for (int i = 0; i < spots.length - 1; i++) {

            //difference between 2 consecutive element in spots[]. If A2 - A1 = 1, and B1 - A1 = 10
            int diff = toNum(spots[i + 1]) - toNum(spots[i]);

            if (diff == 1) { // if HORIZONTAL
                if (pattern == NONE) // if the first time
                    pattern = HORIZONTAL; // set pattern to vertical, this is used for later to check if any illigal change happen
                else if (pattern == VERTICAL) { //if it was Vertical and changed, then error
                    return false;
                }
            } else if (diff == 10) { // if VERTICAL
                if (pattern == NONE) // if the first time
                    pattern = VERTICAL; // set pattern to horizontal, this is used for later to check if any illigal change happen
                else if (pattern == HORIZONTAL) { //if it was Horizontal and changed, then error
                    return false;
                }

            } else {
                return false;
            }
        }
        return true;
    }

    public static int toNum(String s) {
        // A1 => 01 , B1 => 11, C2 => 22
        return Integer.parseInt("" + ((int)s.charAt(0) - 'A') + s.charAt(1));
    }