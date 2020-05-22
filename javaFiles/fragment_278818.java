public void playGame() {
    final String p = playerChoice();
    final String a = aiChoice();

     if (p.equals(a)) {
         if (a.equals("Rock")) {