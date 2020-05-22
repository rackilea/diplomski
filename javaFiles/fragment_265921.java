// data types are not important unless mentioned
class One implements ReadonlyOne
{ 
    protected propertyOne;
    protected String id; 
}

class Two implements ReadonlyTwo
{
    protected ArrayList<? extends ReadonlyOne> arrayOne;
    protected String id;
}

class Three implements ReadonlyThree
{
    protected ArrayList<? extends ReadonlyTwo> arrayTwo;
    protected otherProperty;
}