if(currentState) {
  obj.negate(obj);
  System.out.println("The state has changed to: " + obj.state() + " Should be false");
} else {
  obj.set(obj);
  System.out.println("The state has changed to: " + obj.state() + " Should be true");
}