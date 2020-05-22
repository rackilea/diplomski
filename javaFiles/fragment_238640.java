@Test(expected = IllegalArgumentException.class)
public void shouldThrowExceptionWhenListIsEmpty() {
    doSomeStuff(Collections.emptyList());
}

@Test(expected = IllegalArgumentException.class)
public void shouldThrowExceptionWhenListIsBiggerThanTwo() {
    doSomeStuff(Arrays.asList(new Object(), new Object(), new Object()));
}