int choiceCount = 0;
int choiceCount2 = 0;

while(quitYn == 1)
{

 System.out.println("I am ready for the next participant.");
 System.out.println("");
 System.out.println("");
 System.out.println("What would you rather have?");
 System.out.println("Enter 1 for Love or 2 for Money.");
 surveyChoice = input.nextInt();

 if(surveyChoice == 1)
 {
    choice = FIRST_PICK;
    message = "Love";
    choiceCount++;
 }
 else if(surveyChoice == 2)
 {
    choice = SECOND_PICK;   
    message = "Money";
    choiceCount2++;
 }
 else 
 {
    choice = "Broken dreams";
    message = "Broken dreams";

 }
 }
 System.out.println(choiceCount + "Participants chose" + FIRST_PICK);
 System.out.println(choiceCount2 + "Participants chose" + SECOND_PICK);