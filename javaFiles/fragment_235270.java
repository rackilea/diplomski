/**
 *
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        /*
         * The lines below are deleted since they are not needed. Your game is just
         * about to start. No need to roll the dice and get the score
         */
        // diceRoll();
        // getScore();
        String player1 = args[0]; // Deleted the unnecessary parenthesis. Previously was (args[0])
        String player2 = args[1]; // Deleted the unnecessary parenthesis. Previously was (args[1])
        playBunco(player1, player2); // Pass the player1 and player2 variables to playBunco, so that playBunco method
                                        // will have access to the players
    }

    /*
     * This will be the method that the "play" part will be processed
     *
     * @param player1 The name of player 1
     *
     * @param player2 The name of player 2
     */
    public static void playBunco(String player1, String player2) {
        int player1AllScore[] = { 0, 0, 0, 0, 0, 0 }; // This is used to store the score of player 1. It has six 0's
                                                        // since
                                                        // you have 6 rounds
        int player2AllScore[] = { 0, 0, 0, 0, 0, 0 }; // This is used to store the score of player 1. It has six 0's
                                                        // since
                                                        // you have 6 rounds
        int totalNumberOfRounds = 6; // this is the total number of rounds

        /*
         * This loop is needed to play all the rounds. In this case until round 6 int
         * currentRoundNumer = 1 -> it means that the round should start at round 1
         * currentRoundNumer < totalNumberOfRounds -> this means that the process inside
         * the loop will be repeatedly executed up until the total number of rounds, in
         * this case round 6 currentRoundNumer++ -> this means that we should increment
         * the currentRoundNumber after every round
         */
        for (int currentRoundNumber = 1; currentRoundNumber <= totalNumberOfRounds; currentRoundNumber++) {
            // I am assuming that player1 will take his/her turn first and then followed by
            // player2's turn
            System.out.println("====== Start of round " + currentRoundNumber + " ====== ");
            int player1RoundScore = playOneRound(currentRoundNumber, player1); // This will generate player1's turn
            player1AllScore[currentRoundNumber - 1] = player1RoundScore; // This will save the score of player 1 in this
                                                                            // round. As you can see I decremented 1 to
                                                                            // the current round number, it is because
                                                                            // the array index starts at 0

            int player2RoundScore = playOneRound(currentRoundNumber, player2); // This will generate player2's turn
            player2AllScore[currentRoundNumber - 1] = player2RoundScore; // This will save the score of player 2 in this
                                                                            // round. As you can see I decremented 1 to
                                                                            // the current round number, it is because
                                                                            // the array index starts at 0
            System.out.println("====== End of round " + currentRoundNumber + " ====== \n");
        }

        /*
         * You can do some calculations here regarding the scores of each player. To get
         * the score you can do this: player1AllScore[0]; The above code will get the
         * round 1 score of player 1. Do not forget that you should decrement 1 in each
         * round. so if you want to get the score of player 1 on round 2, you will pass
         * '1', thus it should be player1AllScore[1];
         */
    }

    public static int diceRoll() {
        /*
         * The lines that are deleted below is correct, but since you do not use roll
         * variable in any other process, you can just directly return the generated
         * random, number
         */
        // int roll;
        // roll = (int) (Math.random() * 6 + 1);
        // return roll;
        return (int) (Math.random() * 6 + 1);
    }

    /*
     * This will be the method that will calculate the scores of a player Since you
     * are using roundNumber from your previous code, I am assuming that you are
     * calculating the score in each round
     *
     * @param roundNumber The current round
     *
     * @param dice1 The value of dice 1
     *
     * @param dice2 The value of dice 2
     *
     * @param dice3 The value of dice 3
     */
    public static int getScore(int roundNumber, int dice1, int dice2, int dice3) {
        // diceRoll(); <- you do not need this since you are not rolling the dice, you
        // are just about to calculate the score

        // int roundNumber; <- you do not need this since it is already passed as a
        // parameter

        /*
         * Starting from this point I do not actually understand what you are trying to
         * do so I have just based in on assumptions.
         */
        // [CODE REMOVED FOR BREVITY]
        // int score = 0;
        // if(die1 == roundNumber) {
        // if(die2 == roundNumber) {
        // if(die3 == roundNumber) {
        // score = bunco;
        // }
        // else{
        // score = twoPoints;
        // }
        // }
        // else{
        // score = onePoint;
        // }
        // [ CODE REMOVED FOR BREVITY]
        // return score;

        int score = 0; // initialize the score

        /*
         * just my assumption since from the code above, I think when all the dice
         * values are equal to the round number you will have a bonus points? If so then
         * the above condition will satisfy it
         */
        if (dice1 == roundNumber && dice2 == roundNumber && dice3 == roundNumber) {
            score = 1000; // you do not need to use a variable "bunco", you can directly assign a value.
        }
        /*
         * just my assumption since from the code above, I think when only dice1 and
         * dice2 values are equal to the round number you will have a two points? If so
         * then the above condition will satisfy it
         */
        else if (dice1 == roundNumber && dice2 == roundNumber) {
            score = 2;
        }
        /*
         * just my assumption since from the code above, I think when only dice1 values
         * are equal to the round number you will have a one point? If so then the above
         * condition will satisfy it
         */
        else if (dice1 == roundNumber) {
            score = 1;
        }

        return score;
    }

    /*
     * This will be the method that will do 1 round. It will roll the 3 dice and
     * calculate the score
     *
     * @param roundNumber The current round
     *
     * @param player The name of the player who is playing this round
     */
    public static int playOneRound(int roundNumber, String player) {

        // diceRoll(); <- you do not need this
        int die1 = diceRoll();
        int die2 = diceRoll();
        int die3 = diceRoll();

        // getScore(); <- you do not need this
        int score = getScore(roundNumber, die1, die2, die3);

        // String player; <- you do not need this

        // Since this methods goal is to play 1 round you do not have to loop this
        // for (int roundNumber = 1; roundNumber <= 3; roundNumber++) {
        System.out.println(player + " rolled " + die1 + "," + die2 + "," + die3 + " and scored " + score + " points");
        // }

        // return the score for calculating the total score for all the rounds
        return score;
    }

}