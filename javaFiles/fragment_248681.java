class ThisExample{
    private int aNumber;

    public void setANumber(int aNumber){
        //Here is is necessary to prefix with 'this' to clarify 
        //access to the class instance property 'aNumber'
        this.aNumber = aNumber; 
    }
}