@Test
@TestPrivates 
//since the method is annotated with JUnit's @Test this annotation is redundant. 
// You just need to have dp4j on the classpath.
    public void somethingTest(){
      Something something = new Something();
      int sthSecret = something.internalSecret();
       Assert.assertEquals(43, sthSecret); //cannot use something.internalSecret() directly because of bug [dp4j-13][2] 
    }