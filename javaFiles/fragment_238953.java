int localState1;
String localState2;
synchronized (someObject) {
    // code block 1
    localState1 = state1;
    localState2 = state2;
}

SwingUtilities.invokeAndWait(handler(localState1, localState2));

synchronized (someObject) {
    // code block 2
}