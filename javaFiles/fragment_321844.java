bool someValue = ComputeComplexBooleanValue();
foreach(var item in collection)
{
    if(someValue)
        doStuff(item);
    else
        doOtherStuff(item);
}