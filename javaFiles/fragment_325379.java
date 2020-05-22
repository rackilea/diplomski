testList = FXCollections.observableArrayList();

...

Thread testThread = new Thread(new Test(testList));

testThread.start();