void takeQuiz()
{
     Scanner in = new Scanner(System.in);
     String answer;

     for(int i = 0; i < questions.size(); i++)
     {
         System.out.print(questions[i] + "\nAnswer: ");
         answer = in.next();
         answers[i] = answer;

         if(answer.equalsIgnoreCase(correctAnswers[i])
         {
             score++;
         }
         else
         {
            score--;
         }
     }
}