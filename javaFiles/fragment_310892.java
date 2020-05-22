@Test()  
public void testAddCode_2() throws Exception  
{  
       codeKeeper.addCode("myMagicCode");
       assertTrue(codeKeeper.getList().contains("myMagicCode");  
}