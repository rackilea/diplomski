public class Question{
       String theQuestion;
       ArrayList<Card> answers;// each question has N answers means N cards 

       // create a question 
       Question(String question,ArrayList<Card> ans){
             this.theQuestion = question;
             answers = ans;
             // here you shuffle the answers 
             Collections.shuffle(answers); 
       }
       public boolean checkAnswer(int chosenCardIndex){

                 return answer.get(chosenCardIndex).isItRight();

       }