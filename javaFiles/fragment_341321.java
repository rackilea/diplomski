if(dataSnapshot.exists()) {
    boolean isEnded = dataSnapshot.getValue(Boolean.class);
    if(isEnded) {
        //Your logic
    }
}