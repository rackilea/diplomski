private Map<Integer, Integer> keysHeld = new Hashmap();


@Override
public void nativeKeyPressed(NativeKeyEvent e) {
    //When the countdown gets to 0, do a key update
    if (keysHeld.getOrDefault(e.keyCode(), 0) <= 0) {
        //Do whatever you want to do.

        //Set the countdown again, so it can be activated again after a reasonable amount of time.
        keysHeld.put(e.keyCode(), 50);
    }

    //Decrease the countdown by 1 each update until it triggers or is released.
    keysHeld.put(e.keyCode(), e.getOrDefault(e.keyCode(), 50) - 1);
}

 @Override
 public void nativeKeyReleased(NativeKeyEvent e) {
     //Reset countdown when key is released.
     keysHeld.put(e.keyCode(), 0);
}