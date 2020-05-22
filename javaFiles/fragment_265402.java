try {
  // some code here
} catch ( Exception e) {
  e.printStackTrace();
} catch ( RuntimeException e ) { // this line will cause a compilation error because it would never be executed since the first catch would pick the exception
  e.printStackTrace();
}