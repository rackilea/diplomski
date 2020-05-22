// in one place
webService.delegate = new AsyncResponse() {
    @Override
    void processFinish(String response) {
        // do something
    }
};

// in another place
webService.delegate = new AsyncResponse() {
    @Override
    void processFinish(String response) {
        // do something else
    }
};