void myMethod( int counter)
{
if(counter == 0)
else
{
System.out.println("hello" + counter);
myMethod(--counter);
System.out.println(""+counter);
}
}