class Teller
{
String name;
String dateProcessed;
Boolean Savings; 
int random;

public Teller(String n, String dP, Boolean Savings)
{
    name = n;
    dateProcessed = dP;
    this.Savings = Savings;

    System.out.println("Teller:" + " " + name + " " + "This transaction will process:"     + " " + dateProcessed);
}