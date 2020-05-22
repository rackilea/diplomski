public class TestClass
{
    public class MyClass
    {
        public <K, T> T test(String s, K obj, final Class<T> clazz)
        {
            return null;    
        }
    }

    @Test
    public void test()
    {
        MyClass myClass = Mockito.mock(MyClass.class);

        Mockito.when(myClass.test(Mockito.anyString(), Mockito.any(), Mockito.any(Class.class))).thenThrow(new IllegalArgumentException());

        myClass.test(null, null, null);
    }
}