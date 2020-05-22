class Teller
{
Account acct;
String name;
String dateProcessed;
int random;

public Teller(Account act, String dP)
{
    acct=act;
    name = acct.getname();
    dateProcessed = dP;

    System.out.println("Teller:" + " " + name + " " + "This transaction will process:"     + " " + dateProcessed);
}


public void acctStuff()
{
    if(acct instenceof checkingAccount)
     { //do checking stuff}
    else { //do savings stuff}
}