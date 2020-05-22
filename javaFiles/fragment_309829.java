String answer;
Scanner startFight = new Scanner(System.in);
do {
    answer = startFight.nextLine();
    // ...
} while(!answer.equals(yes) && !answer.equals(no));

startFight.close();