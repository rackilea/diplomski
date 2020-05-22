public int someMethod( int i) {
  if(i < 2) {
    return 1;
  } else {
    return someMethod(i-1)+someMethod(i-2);
  }
}