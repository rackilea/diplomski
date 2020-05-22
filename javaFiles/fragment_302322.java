@Auto private States clockState;
@Test
public void example() {
    clockState.startsAs("first");
    timeNow(100);
    // do something

    clockState.become("second");
    timeNow(105);
    // do something else
}

private void timeNow(final long timeNow) {
    context.checking(new Expectations() {{
        allowing(clock).timeNow(); will(returnValue(timeNow));
        when(clockState.is("first"));

        allowing(clock).timeNow(); will(returnValue(timeNow + 100));
        when(clockState.is("second"));
    }});
}