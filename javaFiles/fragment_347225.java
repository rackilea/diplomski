class GameClass { 
    private int homescore = 0;
    private int awayscore = 0;

    private void resultbuttonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        Random dice = new Random();
        int number;
        for (int counter =1; counter<=1; counter++){
            number = dice.nextInt(2);                   // Creates a 0 or a 1
            if (number == 1){                           // If 1: Point to home team
                homescore = ++homescore;
            } else {                                      // If 0: Point to away team
                awayscore = ++awayscore;
            }
        }
    homescorelabel.setText(String.valueOf(homescore));
    awayscorelabel.setText(String.valueOf(awayscore));
 }
}