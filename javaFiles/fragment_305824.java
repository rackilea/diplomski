save(Enity item){
    try{
        //Try to insert your entity by calling persist method    
    }
    catch(EntityExistsException e){
        //Entity you are trying to insert already exist, then call merge method
    }
}