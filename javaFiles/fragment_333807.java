public  class SimpleWrapper{
    String otherText;
    public SimpleWrapper(){}

    public setOtherText(String otherText){
     this.otherText=otherText;
    }

    @Override
    public String toString(){
        return otherText;
    }
}