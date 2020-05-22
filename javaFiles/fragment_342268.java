try{
  // do stuff...
  fail("Exception not thrown");
}catch(Exception e){
  assertTrue(e.hasSomeFlag());
}