import java.util.Random;
import java.util.Scanner;
public class DiceProbability
{
public static void main(String[] args)
{
    Scanner in = new Scanner(System.in);
    Random randNum = new Random();
int count2 = 0;
int count3 = 0;
int count4 = 0;
int count5 = 0;
int count6 = 0;
int count7 = 0;
int count8 = 0;
int count9 = 0;
int count10 = 0;
int count11= 0;
int count12= 0;
int count13 = 0;
int count14 = 0;
int count15 = 0;
int count16 = 0;
int count17 = 0;
int count18 = 0;
int count19 = 0;
int count20 = 0;
int count21 = 0;
int count22 = 0;
int die1 = 0, die2 = 0;
int rolls = 0;
int actualDiceSum;
double probabilityOfDice = 0.0;

System.out.print("Number of Rolls: ");
rolls = in.nextInt();

for(int timesRolled = 0; timesRolled < rolls; timesRolled++)
    {
    die1 = randNum.nextInt(12);
    die2 = randNum.nextInt(12);
    actualDiceSum = die1 + die2;

        if(actualDiceSum == 2){
        count2++;

        }
        else if(actualDiceSum == 3){
        count3++;

        }
        else if(actualDiceSum == 4){
        count4++;

        }
        else if(actualDiceSum == 5){
        count5++;

        }
        else if(actualDiceSum == 6){
        count6++;

        }
        else if(actualDiceSum == 7){
        count7++;

        }
        else if(actualDiceSum == 8){
        count8++;

        }
        else if(actualDiceSum == 9){
        count9++;

        }
        else if(actualDiceSum == 10){
        count10++;

        }
        else if(actualDiceSum == 11){
        count11++;

        }
        else if(actualDiceSum == 12){
        count12++;

        }
        else if(actualDiceSum == 13){
        count13++;

        }
        else if(actualDiceSum == 14){
        count14++;

        }
        else if(actualDiceSum == 15){
        count15++;

        }
        else if(actualDiceSum == 16){
        count16++;

        }
        else if(actualDiceSum == 17){
        count17++;

        }
        else if(actualDiceSum == 18){
        count18++;

        }
        else if(actualDiceSum == 19){
        count19++;

        }
        else if(actualDiceSum == 20){
        count20++;

        }
        else if(actualDiceSum == 21){
        count21++;

        }
        else if(actualDiceSum == 22){
        count22++;

       }
    }
}


System.out.println("Sum of Dice \t\t Probability");
System.out.println("2's\t\t" + count2/rolls + "%");
System.out.println("3's\t\t" + count3/rolls + "%");
System.out.println("4's\t\t" + count4/rolls + "%");
System.out.println("5's\t\t" + count5/rolls + "%");
//and so on...
}
}