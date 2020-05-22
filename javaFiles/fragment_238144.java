public String handleEditRequest(...) {
    Timer timer = new Timer().start();
    try {
        return handleEditRequestImpl(...);
    } finally {
        timer.stop();
        slaService.send(timer);
    }
}

private String handleEditRequestImpl(...) {
    // Lots of code
}