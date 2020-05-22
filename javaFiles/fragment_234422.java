int quarters;
double balance;
//TODO : Add all other required variables
string verification;

do
{
quarters = getNumberOfQuartersFromUser();
balance = getStartingBalance();
... //TODO : all the other methods
//verification
System.out.println("Is this accepted?");
verification = keyboard.nextString();
//Handle verfication if it is no or No
if (verification == null || verification == "No" || verification == "no")
{
System.out.println("Starting from the beginning again");
}
}
while (verification == null || verification == "No" || verification == "no")
//out of loop, so handle calculation.
...