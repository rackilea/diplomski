public class CheckPasswords extends ConsoleProgram
{
  public void run()
  {  

  while(true)
  {
  String org = readLine("Enter Password: ");
  String check = readLine("Confirm Password: ");
  int mismatchPosition = firstMisMatch(org,check);  
  if(mismatchPosition==-1)
  {
    println("Password Confirmed");
  }
  else
  {
    println("Passwords do not match from position "+mismatchPosition);

      }
   }
  }
}