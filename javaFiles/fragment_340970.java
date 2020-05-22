public   class PrintStar   implements Print , PrintBehavious{

    @Override
    public void printHollowstar(int input) {

        int middle = 0;
        // when input is odd
        if (input % 2 == 1) {
            middle = 1;
            // the top part, let's print from 1 to longest(input) -- 1 5 9 3 7 11
            for (int i = 1; i <= input; i += 4) {
                printStarline(i, input);
                if (i + 2 == input) {
                    printStarline(input, input);
                    middle = i;
                }
                if (i + 4 == input)
                    middle = i;
            }

            // the first middle part
            // let's print from second longest line to shortest (>input/2)
            for (int i = middle;; i -= 4) {
                printStarline(i, input);
                if (i - 4 < (double) input / 2) {
                    middle = i; // the shortest line
                    break;
                }
            }
            // the second middle part
            for (int i = middle + 4; i < input; i += 4) {
                printStarline(i, input);
                middle = i;
            }

            // the bottom part, let's print from the longest line to 1
            for (int i = middle; i >= 1; i -= 4) {
                if (i + 2 == input || i + 4 == input)
                    printStarline(input, input);
                printStarline(i, input);
            }

        }//input odd end

        // when input is even
        if (input % 2 == 0) {

            middle = 2;

            // the top part, let's print from 2 to longest(input) 
            for (int i = 2; i <= input; i += 4) {
                printStarline(i, input);
                if (i + 2 == input) {
                    printStarline(input, input);
                    middle = i;
                }
                if (i + 4 == input)
                    middle = i;
            }

            // the first middle part
            // let's print from second longest line to shortest (>input/2)
            for (int i = middle;; i -= 4) {
                printStarline(i, input);
                if (i - 4 < (double) input / 2) {
                    middle = i; // the shortest line
                    break;
                }
            }
            // the second middle part
            for (int i = middle + 4; i < input; i += 4) {
                printStarline(i, input);
                middle = i;
            }

            // the bottom part, let's print from the longest line to 2
            for (int i = middle; i >= 2; i -= 4) {
                if (i + 2 == input || i + 4 == input)
                printStarline(input, input);
                printStarline(i, input);
            }

        }//input even end

    }

    @Override
    public void printStarline(int num, int input) {
        // TODO Auto-generated method stub

    }
}