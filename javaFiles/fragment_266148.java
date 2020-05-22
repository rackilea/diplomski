public class FooTest {
   class Regressor {
      public Regressor cloneWithSharedResources() {
         return new Regressor();
      }
   }

   class ClassToTest {
      public Regressor foo(Regressor regressor) {
         // ...
         return regressor.cloneWithSharedResources();
      }
   }

   @Test
   public void testFoo() throws Exception {
      Regressor regressor = Mockito.mock(Regressor.class);
      Mockito.when(regressor.cloneWithSharedResources()).thenReturn(regressor);

      ClassToTest classToTest = new ClassToTest();
      Regressor clonedRegressor = classToTest.foo(regressor);

      Assert.assertSame(regressor, clonedRegressor);
   }
}