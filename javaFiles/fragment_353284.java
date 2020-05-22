public boolean subtraction(int itemsSold)
{
    //local constants

    //local variables

    /********************   Start main method  *****************/

    if (employeeTotal - itemsSold >= 0) {
        //Subtracts the items not sold to the employee total
        employeeTotal = (employeeTotal - itemsSold);
        return true; 
    } 

    return false;
}//end subtraction