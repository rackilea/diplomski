public static String findBookByInventoryNumber(Book[] arrayOfBooks, int inventoryNumberSearched) 
{
    String message = "";
    for(int i = 0; i < getNumberOfBooks(); i++) {
        if(inventoryNumberSearched == arrayOfBooks[i].getInventoryNumber()) {
           message = message + arrayOfBooks[i].toString();
        }//end if
    }//end for
    return message;
}//end findByInventory