@Test
public void testGetABC(){
    String hello= null;
    assembleABC(byRef hello); // NOT really allowed, compilation error
    System.out.println(hello);
}

public static void assembleABC(byRef String hello){ // NOT really allowed, compilation error
    hello = "hello";
}