while (in.hasNextInt())
{
 // statements to input the scores, output the scores, accumulate the 
 int input = in.nextInt();
 if (input >= 0 && input <= 100)
 {
   scores[i] = input;
   sum = sum + scores[i];
   out.print(scores[i]);
   i++;
 }
 else
 {
   System.out.println("The ignored score is: " + input);
 }  

}