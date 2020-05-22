public void create(Receiver receiver) throws ReceiverAllreadyExistsException, ReceiverLimitReachedException {
        testIfReceiverLimitReached(receiver);
        testIfReceiverAlreadyExists(receiver);
        getEntityManager().persist(receiver);

    }