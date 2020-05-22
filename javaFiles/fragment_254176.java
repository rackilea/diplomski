if(thisApt.getAptRentalDate() == 0)
{
    System.out.println("Apartment " + theAptID + " is available. Returning!");
    return;
}
else
{  
    System.out.println("Apartment " + theAptID + " is rented out. Returning!");
    return;
}