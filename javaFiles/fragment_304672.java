@Test(expected = ExistsException.class)
public void createUser() throws ExistsException {
    Transaction tx = graphDb.beginTx();
    try {
        UserWrapper user = (UserWrapper) dataService.createUser(BigInteger.valueOf(1));
        tx.success();
    }
    finally {
        tx.finish();
    }
    Node userNode2 = this.graphDb.index().getNodeAutoIndexer().getAutoIndex().get(UserWrapper.KEY_IDENTIFIER, identifier).getSingle();
    assertNotNull(userNode2);

    Transaction tx = graphDb.beginTx();
    try {
        UserWrapper user = (UserWrapper) dataService.createUser(BigInteger.valueOf(1));
        tx.success();
    }
    finally {
        tx.finish();
    }
}