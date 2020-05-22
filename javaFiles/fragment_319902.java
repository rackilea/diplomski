public class A {
    private String myField; //"private" means access to this is restricted

    public String getMyField()
    {
         //include validation, logic, logging or whatever you like here
        return this.myField;
    }
    public void setMyField(String value)
    {
         //include more logic
         this.myField = value;
    }
}