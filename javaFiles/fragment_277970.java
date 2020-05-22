@Test
    public void testWithOneDirectory() {
       String[] directoryList = getDirectoryList("/", "home");
       Assert.assertArrayEquals(" sould equal to on dir",ONE_DIR, directoryList);
    }

    @Test
    public void testShouldThrowException{
       try{
          String[] directoryList = getDirectoryList("/", null);
          fail("Should throw exception when arg is null");
       }
       catch(Exception e) {}
    }