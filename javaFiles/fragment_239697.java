public void method(){

    try{
        methodThrowingIllegalArgumentException();
        return;
    catch (IllegalArgumentException e) {
        try {
            anotherMethodThrowingIllegalArgumentException();            
            return;
        } catch(IllegalArgumentException eee){
            //do some
            return;
        }
    } catch (SomeAnotherException ee){
       return;
    }
}