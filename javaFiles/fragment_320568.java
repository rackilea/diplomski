public void setBranchID(String ID) throws NumberFormatException{
    if(ID.trim().length() != 0 && ID != null){
        try{
            branchID = Integer.parseInt(ID);
        }catch(NumberFormatException ex){
            OutputFunc.printError(ex); //Prints the stack trace to console
            throw new NumberFormatException("setBranchID error : " + ex    );
        }
    }
    else{
        branchID = null;
    }
}