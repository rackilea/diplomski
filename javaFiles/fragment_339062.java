@Test
public void TestGenerateIDReturnsLong()
{
   Method method = 
      VGenerator.class.getDeclaredMethod("generateID", new Class[0]);
   Assert.Equals(long.Class, method.GetReturnType());
}