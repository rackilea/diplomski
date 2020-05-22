MyClass c = new MyClass(); 
someClassICanMock  m = mock(someClassICanMock.class);
doNothing().when(m).doSomething();
MyClass s = spy(c);
s.methodToTest();
verify(s , times(1)).methodFromSameClassIWantToVerify();