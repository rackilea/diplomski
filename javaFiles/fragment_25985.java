string A = null;
string B = "Hello World";

if ( A != null && B != null)
{
    // Do this
}
else if ( A == null ^ B == null )
{
    throw new Exception("Both inputs must have a value or neither should");
}