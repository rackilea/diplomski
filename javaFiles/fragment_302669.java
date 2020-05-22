public void isEmptyTest(){
  Stack emptyStack = new Stack();
  assertFalse(emptyStack.isEmpty());
}

public void isEmptyTest(){
  Stack nonEmptyStack = new Stack();
  nonEmptyStack.push(1);
  assertFalse(nonEmptyStack.isEmpty());
}