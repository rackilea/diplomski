OnClickListener someListener = getListener(); // this creates your implementation.
try {
    buttonSubtract.setOnClickListener(someListener);
} catch (NumberFormatException e) {
    // do stuff
}