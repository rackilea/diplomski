public void testStore() throws Exception {
    try {
        itemSrvc.storeItem(items);
        Assert.fail();
    }
    catch (ItemNotStoredException e) {
    }
 }