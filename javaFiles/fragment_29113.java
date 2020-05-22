int d1 = rollDie(1,6);
int d2 = rollDie(1,6);
int d3 = rollDie(1,6);

if (isStraight(d1, d2, d3)){
    System.out.println("You got a Straight!");
    printDice(d1, d2, d3);
    wins = wins + 1;
}
else if (isTriple(d1, d2, d3)){
    System.out.println("You got a Triple!");
    printDice(d1, d2, d3);
    wins = wins + 1;
}
else if (isPair(d1, d2, d3)){
    System.out.println("You got a Pair!");
    printDice(d1, d2, d3);
    ties = ties + 1;
}
else if (isNone(d1, d2, d3)){
    System.out.println("Try Again!");
    printDice(d1, d2, d3);
    loses = loses + 1; 
}