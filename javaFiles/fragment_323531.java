public class vInteger extends Integer implements Comparing
{
    ...

    public int compare(Comparing obj)
    {
        // here you can access this.getIntValue() (the getter of your Integer class)
        // however, obj.getIntValue() wouldn't work, since `obj` can be of any
        // class that implements `Comparing`. It doesn't have to be a sub-class of
        // your Integer class. In order to access the int value of `obj`, you must
        // first test if it's actually an Integer and if so, cast it to Integer
        if (obj instanceof Integer) {
            Integer oint = (Integer) obj;
            // now you can do something with oint.getIntValue()
        }
    }

    ...
}