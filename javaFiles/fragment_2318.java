if (eOS == 1 && numberx == 1) {
        System.out.println("you have played the emperor! \n the emperor 
 is defeated by the slave");

}
else if (eOS == 2) 
{
        if (numberx == 1) {
             System.out.println("you have played the citizen, this 
             defeats the slave");
        }
        else if (numberx == 2) {
             System.out.println("you have played the citizen, this 
             ties with the citizen");
        }

        else if (numberx == 3) {
              System.out.println("you have played the citizen, 
           this defeats the slave");
        }
        else
        {
             //print out something else if number is not 1,2 or 3
        }
}