import java.util.Random; 

public class Craps{ public static void main(String [] args){

Boolean winLose = false;

int dice1 = (int)(Math.random()*6) + 1;
int dice2 = (int)(Math.random()*6) + 1;
int sum = dice1 + dice2;


if ((sum == 7) || (sum == 11)){ 
 System.out.println("You Win!");
 return;}

 else if ((sum == 2) || (sum == 3) || (sum == 12)){
 System.out.println("You Lose!");
 return;}

while(!winLose){
    System.out.printf("Your Point: %d\n", sum); 

    dice1 = (int)(Math.random()*6) + 1;
    dice2 = (int)(Math.random()*6) + 1;
    int point = dice1 + dice2;


    System.out.printf("You rolled: %d %s %d %s %d\n",dice1,"+",dice2,"=",point);
    if (point == sum){ 
        winLose = true;
        System.out.println("You Win!");      
    }
    if (point == 7){
        winLose = true;
        System.out.println("You Lose!");
    }

} 


.
.
.
.(complete the codes..)