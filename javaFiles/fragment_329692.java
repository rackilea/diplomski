try {
    Thread.sleep(NOTE_DURATION);
} catch (InterruptedException e) {
    // XXX need to stop playing here, maybe return or break?
    return;
}