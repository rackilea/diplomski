@Test
public void boostValueTest() {
    Servants servants = mock(Servants.class);
    when(playerHandler.getResourceHandler()).thenReturn(servants);

    when(playerHandler.getResourceHandler().getServants()).thenReturn(3).thenReturn(5);

    //3 is less than 4 . assert you cannot boost
    Boolean bool1  = fmBase.boostValue(fm, 4);
    assertFalse( bool1 );

    //5 is not less than 4 . assert you can boost
    Boolean bool2  = fmBase.boostValue(fm, 4);
    assertTrue( bool2 );
}