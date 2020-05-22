@Test
public void testmethod(){
  System.out.println("test");
}

@AfterMethod
public void aftermethod(Method m){
  String methodNameOfTest = m.getName();
  System.out.println(methodNameOfTest);
}