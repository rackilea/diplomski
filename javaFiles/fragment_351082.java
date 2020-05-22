if(function ==log||function == sin||etc.) 
//Something like this in conditional
{
 value2 = user.nextDouble(); 
 //get user input only once for special cases that satisfy conditional
}
else
{
  value1 = user.nextDouble(); //get user input normally.
  String op = user.next();
  value2 = user.nextDouble();
}