int userGuess = 002;
boolean userFound = false;
for (employee l : list)
{
    if (userGuess == l.empid)
    {
       userFound = true;
       l.display();
       break;
    }
}

if(!userFound)
{
   throw new InputMismatchException ("employee doesnot exist");
}