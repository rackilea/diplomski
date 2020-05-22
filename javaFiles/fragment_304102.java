if(testLst != null) {
   testLst.remove(something);
   if (!testLst.isEmpty()) {
       for (Test test : testLst) {
          if (test.getName().equalsIgnoreCase("TEST")) {
           // do blah
          }