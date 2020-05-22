public class RaceWinners{
    public static void main(String[] args) {
        int[] percentages = {25,10,25,10,10,20};
        System.out.print(pickWinner(percentages));
    }

    //Returns the index of the winner(A = 0, B = 1, ...)
    private static int pickWinner(int[] percentages) {
        int randomNumber = (int)(Math.random() * 100);
        int countdown = randomNumber;
        for(int i = 0; i < percentages.length; i++) {
            countdown -= percentages[i];
            if(countdown < 0) {
                return i;
            }
        }
        return -1;
   }

}