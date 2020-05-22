public class StackOverflow_59349187 {

    public static void main(String[] args) {
        Scanner o = new Scanner(System.in);
        System.out.print("Input max match: ");
        int q = o.nextInt();

        List<Match> matches = new ArrayList<>();

        for (int i = 0; i < q; i++) {   // q is the number of turns
            System.out.println("Match " + String.valueOf(i + 1));
            System.out.print("1st player: ");
            int player1Input = o.nextInt();   //first player input
            System.out.print("2st player: ");
            int player2Input = o.nextInt();   //second player input
            int diff = Math.abs(player1Input - player2Input);   //getting the difference
            int winner = (player1Input > player2Input) ? 1 : 2;   //picking the winner for the turn
            Match match = new Match(winner, diff);
            matches.add(match);
        }

        if(matches.size() > 0) {
            Match maxDiffMatch = matches.get(0);
            for (int j = 0; j < matches.size(); j++) {
                Match currentMatch = matches.get(j);
                int currentDiff = currentMatch.getDiff();
                int maxDiff = maxDiffMatch.getDiff();
                if (currentDiff > maxDiff) {
                    maxDiffMatch = currentMatch;
                }
            }
            System.out.printf("Winner player: %d Max diff: %d", maxDiffMatch.getPlayer(), maxDiffMatch.getDiff());
        }
    }

    static class Match {
        private final int player;
        private final int diff;

        public Match(int player, int diff) {
            this.player = player;
            this.diff = diff;
        }


        public int getPlayer() {
            return player;
        }

        public int getDiff() {
            return diff;
        }
    }
}