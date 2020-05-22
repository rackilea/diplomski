//do-while loop: execute and then check for condition
//and then if condition holds, execute a second time and so on
do {
    int d3 = (int) (6 * Math.random() + 1);
    int d4 = (int) (6 * Math.random() + 1);
    roll = d3 + d4;

    System.out.println("your roll is " + roll + " and point is " + point);

} while(roll != 7 && roll != point );

if (roll == 7) 
    System.out.println("you lose");
else
    System.out.println("you win");