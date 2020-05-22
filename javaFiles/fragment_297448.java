@Test
public void delegatingInvocationsToACustomDelegate(@Mocked final DependencyAbc anyAbc)
{
   new Expectations() {{
      anyAbc.myFunction(any);
      result = new Delegate() {
         String aDelegateMethod(String s)
         {
            return s;
         }
      };
   }};

   // assuming doSomething() here invokes myFunction()...
   new UnitUnderTest().doSomething();
}