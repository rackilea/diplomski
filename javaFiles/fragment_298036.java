public class MyClass
{
    private string myField; //"private" means access to this is restricted

    public string getMyField()
    {
         //include validation, logic, logging or whatever you like here
        return this.myField;
    }
    public void setMyField(string value)
    {
             //include more logic
             this.myField = value;
    }
}