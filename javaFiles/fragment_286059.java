public double getCurrent() throws IllegalStateException{
    //check if element
    try{
        if(isCurrent() == true){
            return data[cursor];
        }else{
            throw new IllegalStateException("No Element");
        }//end check        
    }//end try
    catch(IllegalStateException e){
        //print error message to console
        System.out.println(e.getMessage());
    }//end catch        
}//end method