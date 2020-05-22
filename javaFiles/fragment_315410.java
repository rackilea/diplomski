private static String getResults(int currentEnd) {      
    int player1totalscore = 0; //4 instances of int where each player's score will be stored.
    int player2totalscore = 0;
    int player3totalscore = 0;
    int player4totalscore = 0;

    for (int count = 0; count < player.length; count++) {           
        for (int i = 0; i <= currentEnd; i++) {
            if(count == 0) //when first player
                player1totalscore += scores[count][i];  //add score
            if(count == 1) //when 2nd player
                player2totalscore += scores[count][i];  //add score
            if(count == 2) //when 3rd player
                player3totalscore += scores[count][i];  //add score
            if(count == 3) //when 4th player
                player4totalscore += scores[count][i];  //add score            
        }           
    }
    String result = "";
    for (int count = 0; count < player.length; count++) {
        result += player[count];
        for (int i = 0; i <= currentEnd; i++) {             
            if(i==currentEnd){   //when the string is at player's last score entry, add his/her score at the end            
            if(count == 0)
                result += "\t" + scores[count][i] + "\t" + " | " + player1totalscore;
            if(count == 1)
                result += "\t" + scores[count][i] + "\t" + " | " + player2totalscore;
            if(count == 2)
                result += "\t" + scores[count][i] + "\t" + " | " + player3totalscore;   
            if(count == 3)
                result += "\t" + scores[count][i] + "\t" + " | " + player4totalscore;
            } else { //otherwise, keep adding individual scores
                result += "\t" + scores[count][i];
            }               
        }            
        result += "\n";            
    }
    return result;
}