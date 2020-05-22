// borrow method
public boolean borrow(String borrowerID) 
{
    // Temp debug statement.

    // System.out.println ("borrow [" + borrowerId + "]");

    // "Not available" or "invalid borrower" means reject request.

    if (status != 'A')
        return false;

    if (! borrowerID.matches("U([0-9]{3})"))
        return false;

    // Okay to borrow.

    this.borrowerID = borrowerID;
    this.status = 'O';
    this.dateBorrowed = currentDate;

    return true;
}