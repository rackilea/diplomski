public abstract class SuperClassA
{
    //this is the template method
   public void unpack() throws IOException
   {
             if(isValid()){
                templateUnpack();
                setValid(false);
             }

    }

    protected abstract boolean isValid();

    public void templateUnpack() throws Exception {
        //unpack code here
    }
    protected abstract void setValid(boolean b);

}