animal p1 = new animal();
animal p2 = new dog();
try {
  System.out.println(p2.getClass().getDeclaredMethod("getTitle"));
} catch(NoSuchMethodException e) {
  // error handling in the case getTitle() doesn't exit
}