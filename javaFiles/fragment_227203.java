public void dummyTest() throws InterruptedException, ExecutionException {

       InitiatorFlow flow = new InitiatorFlow(5, 100, bob.getInfo().getLegalIdentitiesAndCerts().get(0).getParty()); 
       CordaFuture<SignedTransaction> future = alice.startFlow(flow);

        network.runNetwork();
        SignedTransaction signedTransaction = future.get();
    }