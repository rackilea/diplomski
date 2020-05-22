try{
    Method m = underTest.getClass().getMethod("getBar");
    // no exception means the method is implememented
    // Do your mocking here
    doReturn( "BAR" ).when( underTest, "getBar" );
}catch(NoSuchMethodException e){}