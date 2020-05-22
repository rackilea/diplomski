public class MyClass()
{
    private String temp;

    public MyClass(String temp)
    {
        this.temp = temp;
    }

    public MyClass copy()
    {
       MyClass copy = new MyClass(this.temp);
       //set attributes in constructor or using setters so they are the same as this object
       return copy;
    }
}