// made this static so you don't need a class reference
public static int move()
 {
     Random random = new Random();
     int generatedNum = random.nextInt(7 - 1) + 1;

     return generatedNum;
 }

public static void main(String[] args)
{
    int player1 = 0;
    int player2 = 0;

    // Now we just call the static method move to set the ints.
    player1 = move();
    player2 = move();

}