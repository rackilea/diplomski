class Shape
{
    // No one picked up my C++ syntax goof ;-)
    protected PShape pshape;

    // Using a constructor is just one way to do it.
    // A factory pattern may work or even just empty constructor and a
    // load() method.
    public Shape(String filename)
    {
        pshape = loadShape(filename);
        // Add any Shape specific setup
    }


}