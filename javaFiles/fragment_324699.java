public String toString() 
    { 
        Chair myChair = new Chair(); 
        return "The id is: " + myChair.getIdNum() + " and the price of the item is: " + myChair.getTotalPrice() + 
                " Is there an armrest ? ==> " + getArmRest() ; 
    }