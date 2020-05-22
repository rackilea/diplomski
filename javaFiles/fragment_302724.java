while(true){
    String userInput = userInputReader.nextLine();
    if(userInput.equals("yes")){ //note strings are compared with .equals, not ==
       //"yes" case
       //generate your numbers for "yes"
       break;
    }else if(userInput.equals("no")){
       //"no" case
       //generate your numbers for "no"
       break;
    }else{
       //neither "yes" nor "no"
       //note that the continue statement is redundant and 
       //the whole else-block can be omitted
       continue; 
    }
}