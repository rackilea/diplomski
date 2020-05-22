Random r = new Random();
int rndm = 0;

String[][] wordsUsed = new String[2][2];
wordsUsed[0][0] = "Word 1";
wordsUsed[0][1] = "0";
wordsUsed[1][0] = "Word 2";
wordsUsed[1][1] = "0";

String wordsCopy[][] = new String[2][2];

int ctrR = 0;
int ctrC = 0;
boolean isDone = false;

while(!isDone) {

    rndm = r.nextInt(wordsUsed.length);

    if (wordsUsed[rndm][1].equalsIgnoreCase("0") 
            || wordsUsed[rndm][1].equalsIgnoreCase("1")){

        if (wordsUsed[rndm][1].equalsIgnoreCase("0")){
            wordsCopy[ctrR][ctrC] = wordsUsed[rndm][0];
            wordsUsed[rndm][1] = "1";
        } else {
            wordsCopy[ctrR][ctrC] = wordsUsed[rndm][0];
            wordsUsed[rndm][1] = "2";
        }     

        if(ctrC == wordsCopy.length - 1){
            ctrR++;
            ctrC = 0;
        } else { 
            ctrC++;
        }
    }

    if(ctrR == wordsCopy.length){
         // If ctrR reached the length, we have successfully completed copying
        isDone = true;
    }    
}           


///////////////// RESULTS /////////////////

// Values of wordsUsed array
for(int i = 0; i < wordsUsed.length; i++){
    for(int j = 0; j < wordsUsed.length; j++){
        System.out.print(wordsUsed[i][j] + "\t");

    }
}

System.out.println("\n");

// Values of wordsCopy array    
for(int i = 0; i < wordsCopy.length; i++){
    for(int j = 0; j < wordsCopy.length; j++){
        System.out.print(wordsCopy[i][j] + "\t");

    }
}