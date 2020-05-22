public class MainGUI extends Composite 
{   
    private TestGwt270ClientImpl serviceImpl;
    ...
    public MainGUI(TestGwt270ClientImpl serviceImpl)
    {
        this.serviceImpl = serviceImpl; //this line is the solution to my problem
        ...