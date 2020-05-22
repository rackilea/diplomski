public class unhandled extends handleException {

    //added by compiler
    public unhandled() { 
        super(); //note that this super will call the non-parameterized constructor of your parent class, i.e., handleException
    }

    public static void main(String args[])throws handleException
    {
        float a=7/0;
        if(Double.isNaN(a))
        {
            throw new handleException("Exception is handled");
        }
    }
}