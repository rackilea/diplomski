@Override
public void onFrame(Controller arg0) {
    Frame frame = arg0.frame();
    for (int i = 0; i < frame.gestures().count(); i++) {
        Gesture gesture = frame.gestures().get(i);
        if (gesture.type() != Type.TYPE_INVALID)
            System.out.println(gesture.type().toString());
    }
}