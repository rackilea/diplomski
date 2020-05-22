void inAnotherThread() {
    Map localReference = myMap;
    if (localReference != null) {
        localReference.acess();
    }
}