@Test
public void testRealWorkWithoutSendingMessage() {
    SomeClass thing = new SomeClass() {
        @Override
        public void sendMessage( /*some parameters*/ ) { /*do nothing*/ }
    }

    thing.doit();
    assertThat( "Good stuff happened", x, is( y ) );
}