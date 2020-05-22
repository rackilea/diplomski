@org.junit.jupiter.api.Test
public void testMockPrivateMethod() throws Exception {
    MyClass myClass = PowerMockito.mock(MyClass.class);
    PowerMockito.when(myClass.B()).thenReturn("mockB");
    System.out.println(myClass.B());
}

Output:
B called

org.mockito.exceptions.misusing.MissingMethodInvocationException: 
when() requires an argument which has to be 'a method call on a mock'.
For example:
    when(mock.getArticles()).thenReturn(articles);

Also, this error might show up because:
1. you stub either of: final/private/equals()/hashCode() methods.
   Those methods *cannot* be stubbed/verified.
   Mocking methods declared on non-public parent classes is not supported.
2. inside when() you don't call method on mock but on some other object.