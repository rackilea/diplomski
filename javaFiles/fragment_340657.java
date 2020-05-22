@Override
public void onReceive(Object message) throws Exception {
    if(message instance of MessageFromGrandParent) {
        child.forward(message, getContext());
    }
    // ...
}