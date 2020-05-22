class Jahkr {

    int[][] board;

    String[] filenames = new String[]{"first.txt","second.txt","third.txt"};

    loadBoard(int i) {
        Scanner sc = new Scanner(new File(filenames[i])); // 0, 1, 2 allowed
        // proceed to load the board from the file using the scanner
    }

}