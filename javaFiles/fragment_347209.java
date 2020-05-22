if(currentState) {
  obj.setState(Boolean.FALSE);
  System.out.println("The state has changed to: " + obj.state() + " Should be false");
} else {
  obj.setState(Boolean.TRUE);
  System.out.println("The state has changed to: " + obj.state() + " Should be true");
}