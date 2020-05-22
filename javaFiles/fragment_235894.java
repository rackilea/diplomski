if (studentType.equalsIgnoreCase("R"))
{
    do{
       System.out.println("Please enter the number of credits that you are taking:");
       creditNumber = input.nextInt();

        if (creditNumber <= 18)
        {
            System.out.println("Tuition and fees report for " + name);          
            System.out.println("Tuition: "+ tuition);           
            System.out.println( "Capital Fee:  \t"+ capitalFee1);           
            System.out.println( "Student Activities Fee: \t "+   studentACTFee);            
            System.out.println( "Parking Infrastructure Fee: \t " +  parkingFee);           
            System.out.println("Tuition & Fees Per Credit: " +  perCreditR);            
            System.out.println("X Number of Credits: " + creditNumber);
            totalTF = creditNumber * perCreditR;            
            System.out.println("Total Tuition and Fees: \t" +  totalTF);
            System.out.println("Bodly NOVA");
        }
        else {System.out.println("Please re-enter credit Number ");}
    }while(creditNumber > 18);
}