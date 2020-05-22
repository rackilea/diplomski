public class IImplementCloneableButThrowException implements Cloneable{

    //Javadoc has a separate section for Exception, implementation like 
    //this and should clearly specify the condition in which 
    //CloneNotSupportedException will be thrown. 
    public Object clone() throws CloneNotSupportedException {
        //I implement but still wont clone, may be in future will allow myself to be cloned
        throw new CloneNotSupportedException("Sorry I cannot be cloned!");
    }
}