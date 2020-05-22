public abstract class A 
{
    protected Person[] people;

    public final void execute() 
    {
         initPeople();
         performOperations();
    } 
    protected abstract void initPeople();
    protected abstract void performOperations();
}