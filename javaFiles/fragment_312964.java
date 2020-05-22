@Test(
    expectedExceptions = MyException.class,
    expectedExceptionsMessageRegEx = "^regex for message here$"
)
public void testWhatever() 
{
    codeThatRaisesSomeException();
}