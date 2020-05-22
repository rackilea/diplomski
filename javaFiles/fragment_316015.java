public interface Shape
{
    methodSpecificToAllShape();
    method2SpecificToAllShape();
}


public class Sphere implements Shape
{
    @Override
    methodSpecificToAllShape()
    {
       //...
    }

    @Override
    method2SpecificToAllShape()
    {
        //...
    }

    /*
     * It does not stop you from adding method for a specific shape
     */
    public void method3SpecificToSphere()
    {
        //...
    }
}