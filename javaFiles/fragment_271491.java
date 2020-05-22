public String inputContract()
{

    System.out.print("Please enter your contract ID: ");
    String contractID = userInput.nextLine(); // wrong one , local variable  
    contractID = userInput.nextLine(); // should be this 
    return contractID;
}