long? myLongVar = null;
if (myLongVar == null) // or !myLongVar.HasValue, if you prefer
{
    myLongVar = 5L;
    long noLongerNullable = myLongVar.Value;
}