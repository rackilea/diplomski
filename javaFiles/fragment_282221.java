@Test
testIfThrowsException(){
    try{
        funcThatShouldThrowException(arg1, agr2, agr3);
        assertTrue("Exception wasn't thrown", false);
    }
    catch(DesiredException de){
        assertTrue(true);
    }
}