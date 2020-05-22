public static void main(String args[]) throws IOException {
        int press = 0;
        int[] prevScore = new int[] { 0 };

        String[] prevScoreName = new String[] { "John Doe" };
        do {
            int menuchoice = 0;

            System.out.println("Menu choice: 1 to start game, 2  print instructions," + "3 prev score");