public void frameHandler() {
    ....
    addComponentsToFrame(getContentPane());
    actionListenerCalls();//<-- invoke here
    setVisible(true);
}