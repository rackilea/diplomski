Something v = /*Default Value*/ // Will be overwritten if subsequent methods succeed.
Object temp = a.getB(); // Use whatever Object type getB() returns.
if(temp != null){
    temp = temp.getC(); 
    /* If getC() returns a different type of object, 
     * either use a different variable or make the temp variable even broader 
     * (such as the generic Object type) */
    if(temp != null){
        temp = temp.getD();
        if(temp != null){
            temp = temp.getE();
            if(temp != null)
                v = temp; 
                /* If all previous calls returned something substantial, 
                 * v will be something useful */
            }//if(getE() != null)
        }//if(getD() != null)
    }//if(getC() != null)
}//if(getB() != null)