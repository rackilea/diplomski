public void setX(double x) {
    try{ 
        if (x <= 0){
            throw new NegArgumentException();
        }//end if
        else{
            this.x = x;

        }//end else
    }//end try
    catch (NegArgumentException e){
        System.out.println("error");
    }//end catch

}