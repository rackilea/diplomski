@Test
public void send() {
    //when
    boolean sent = sendAsync(address, records, socket, true);
    //then
    if (sent) {
        await().until(receivedPackageCount(), equalTo(false));
    }
}

private Callable receivedPackageCount(String address) {
    return new Callable() {
        @Override
        public boolean call() throws Exception {
            return acknowledgementCache.asMap().containsKey(address);
        }
    };
}