@Parameters({ "first-name" })
@Test
public void testSingleString(String firstName) { 
  System.out.println("Invoked testString " + firstName);
  assert "Cedric".equals(firstName);
}