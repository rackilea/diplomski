@Test
public void testGetABC(){
    String hello= null;
    hello = assembleABC();
    System.out.println(hello); // not null anymore
}

public static String assembleABC(){
    return "hello";
}