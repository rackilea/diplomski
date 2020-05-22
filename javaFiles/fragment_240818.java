// Keep reading until the input is 10
while (nNumber != SENTINEL) 
{

    System.out.println("\nPlease select an item from the menu above: ");

    // Read number entered by the user
    nNumber = input.nextInt();

    if (nNumber == SENTINEL) 
    {   
        System.out.println("Thank you for ordering with Grapefruit Company, " + CustomerName);
        // The user's just entered the value held for SENTINEL - leave the while loop.
        break;
    } 

    // Calculate the total price.
    nTotal = nTotal + prices[nNumber-1];


    // Increment the total number of products entered.
    nProducts++;
}