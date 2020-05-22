public final void DetermineWinner(int yourChoice, int computerChoice){
    //determines the winner
    if(yourChoice == computerChoice){
        JOptionPane.showMessageDialog(null,"It's a tie!");
        tieGames++;
        return; // with return we exit the function at this point. Otherwise another case could be executed from below.
    }

    if (yourChoice == 0) {
        if (computerChoice == 1) {
            JOptionPane.showMessageDialog(null,"You chose:Rock  \n Computer chose:Paper \n Rock loses against Paper YOU LOSE! :-(");
            lossGames++;
        } else {
            // computerChoice has to be 2.
            JOptionPane.showMessageDialog(null,"You chose:Rock \n Computer chose:Scissors \n Rock beats Scissors You WIN!");
            wonGames++;
        }
    }

    if (yourChoice==1){
        if (computerChoice == 0) {
            JOptionPane.showMessageDialog(null,"You chose:Paper \n Computer chose:Rock \n Paper beats Rock You WIN!");
            wonGames++;
        } else {
            //computerChoice has to be 2.
            JOptionPane.showMessageDialog(null,"You chose:Paper \n Computer chose:Scissors \n Paper loses against Scissors YOU LOSE! :-(");
            lossGames++;
        }
    }

    if (yourChoice==2){
        if (computerChoice == 0) {
            JOptionPane.showMessageDialog(null,"You chose:Scissors \n Computer chose:rock \n Scissors lose against Rock YOU LOSE! :-(");
            lossGames++;
        } else {
            //computerChoice has to be 1.
            JOptionPane.showMessageDialog(null,"You chose:Sissors \n Computer chose:Rock \n Scissors beats Paper You WIN!");
            wonGames++;
        }
    }
}

public static int ConvertStringtoNum(String userChoice){

    if (userChoice.equals("rock") || userChoice.equals("r") || userChoice.equals("0")) {
        yourChoice = 0;
    }

    if (userChoice.equals("paper") || userChoice.equals("p") || userChoice.equals("1")) {
        yourChoice = 1;
    }

    if (userChoice.equals("scissors") || userChoice.equals("s") || userChoice.equals("2")) {
        yourChoice = 2;    
    }

    return yourChoice;
}