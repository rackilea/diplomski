public class Variable<T> 
{

    private T value;

    public void setValue(T value)
    {
        this.value = value;
    }

    public T getValue()
    {
        return value;
    }

    public String toString()
    {
        return value.toString();
    }
}

Map<String, Variable<?>> myVars = new HashMap<>();

Variable<Double> v1 = new Variable<>();
v1.setValue(3.0);

Variable<String> v2 = new Variable<>();
v2.setValue("hello");

myVars.put("doubleVar", v1);
myVars.put("stringVar", v2);

System.out.println("doubleVar = " + myVars.get("doubleVar"));
System.out.println("stringVar = " + myVars.get("stringVar"));