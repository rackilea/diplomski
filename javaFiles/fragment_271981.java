void someMethod(InputStream incomingIs) throws SomeException {
    try(InputStream is=incomingIs;// it must be documented that we will close incomingIs
        SomeIOStream io1 = new SomeIOStream(someSortOfProcessing()) ) {
        io1.moreStreamProcessing();
        try(SomeIOStream io2 = new SomeIOStream(someSortOfProcessing(io1));
            SomeIOStreeam io3 = new SomeIOStream (is) ) {
            //do stuff with io2 and io3
        }
    }
}