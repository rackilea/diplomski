public Payload constructPayload(final Data data) {

    //implement any thread safety mechanism as requirdhere. 
    // synchronized is just for explanatory purposes
    synchronized (data) {
        if (data.getType().equals("PayloadA")) {
            return new PayloadA.Builder(data.getDeviceId())
                    //.setGuid("someGuid")
                    //other setters
                    .build();
        } else {
            return new PayloadB.Builder(data.getEventType())
                    //.setCreationDate("someCreationDate")
                    // other setters
                    .build();
        }
    }
}