@Test
public void test() {

    UserDetails userDetails = new UserDetails();
    userDetails.setAge((short) 23);
    userDetails.setEmail("kumar.sambhav.jain@gmail.com");
    Assert.assertNotNull(userDetails);
    Assert.assertNotNull(userDetails.getEmail());
    // Start monitoring changes
    userDetails.startMonitor();

    userDetails.setAge((short) 23);
    Assert.assertFalse((userDetails.hasChanged()));  // 23 to 23 -> not changed
    userDetails.setEmail("kjai10@gmail.com");
    Assert.assertTrue(userDetails.hasChanged());
    Assert.assertNotNull(userDetails.hasChanged("email"));
    Assert.assertTrue(userDetails.hasChanged("email").equals(
            "kumar.sambhav.jain@gmail.com"));


    SampleBean sb = new SampleBean();
    sb.startMonitor();
    System.out.println(sb.hasChanged());;

}