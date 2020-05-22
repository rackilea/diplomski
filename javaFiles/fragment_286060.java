public double getCurrent() throws IllegalStateException{
    //check if element
    if(isCurrent() == true){
        return data[cursor];
    }else{
        throw new IllegalStateException("No Element");
    }//end check      
}//end method