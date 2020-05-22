doThrow(new MyException()).when(myMock).myMethod();

try {
    myMock.myMethod();
    fail("MyException should have been thrown!");
} catch (MyException expected) {
    // Do something
}

System.out.println("Here"); 
// Verify the mock, assert, etc.