@Test
public void testCrossCast(){
    Object initial = ... // retrieve it as you did before
    User result = CrossCastUtils.cast(initial);

    assertFalse(initial instanceof User);
    assertTrue(result instanceof User);
}