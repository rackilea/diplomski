Frame lastFrameProcessed = Frame.invalid();
public void onFrame(Controller controller)
{

    //Get the most recent frame
    Frame frame = controller.frame();
    //Verify a hand is in view
    if (frame.hands().count() > 0)
    {
        GestureList gestures = frame.gestures(lastFrameProcessed);
        for (Gesture gesture: gestures)
        {
            if (gesture.type() == Type.TYPE_KEY_TAP)
            {
                KeyTapGesture keytap = new KeyTapGesture (gesture);
                System.out.println("KEYTAPPED");
            }
        }

        //Send the tap data to the Arduino
        // TBD
        //Give the Arduino some time to process our data
        try { Thread.sleep(30); }
        catch (InterruptedException e) { e.printStackTrace(); }
    }
    lastFrameProcessed = frame;
}