public boolean subtraction(int itemsSold)
{
    //local constants

    //local variables

    /********************   Start main method  *****************/

    //Subtracts the items not sold to the employee total
    employeeTotal = (employeeTotal - itemsSold);

    return employeeTotal < 0;
}//end subtraction