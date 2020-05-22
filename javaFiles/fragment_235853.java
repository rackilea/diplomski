public int winPercentage (double currentMoney, double theTarget, double minBet) {
  int numberWin = 0;
  for (int i=0; i<=10; i++){
    boolean win = calRate(currentMoney, theTarget, minBet);
    if (win){
      numberWin = numberWin + 1;
    }

  }
  return numberWin;
}