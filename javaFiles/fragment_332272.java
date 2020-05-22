@PostLoad
protected void initSomeTransientString() {
    //Likely some more complex logic to figure out value,
    //if it is this simple, just set it directly in field declaration.
    someTransientString = "imamightilyfinestring";
}