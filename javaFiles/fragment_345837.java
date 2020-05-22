public class Play 
{

    private static int noOfCards = 16;
    private static Stack<Integer> player1 = new Stack<Integer>();
    private static Stack<Integer> player2 = new Stack<Integer>();

    static void takeCard(Stack<Integer> st,int cardValue){
        st.push(cardValue);
    }

    static int discardCard(Stack<Integer> st){
        return st.pop();
    }

    static int getRandomValue(int min, int max){
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    //Filled card pile with random values from 1-13
    public static void main(String[] args)
    {
        for(int i = 0 ; i < noOfCards; i++){
            takeCard(player1,getRandomValue(1,13));
            takeCard(player2,getRandomValue(1,13));
        }

        //player 1 takes a card!
        //Size of player1's pile before and after taking card
        System.out.println("Before:" + player1.size());
        takeCard(player1, getRandomValue(1, 13));
        System.out.println("After" + player1.size());
        //player 2 discards a card and outputs the card's value
        System.out.println("Player 2 discards: " + discardCard(player2));
    }
}