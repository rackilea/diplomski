server.addLookupListener(new MOServerLookupListener() {
    @Override
    public void lookupEvent(MOServerLookupEvent event) {
        System.out.println();
        ((MOScalar)event.getLookupResult()).setValue(new OctetString(new Date().toString()));
    }
    @Override
    public void queryEvent(MOServerLookupEvent event) {
        System.out.println();
    }
},moScalar);