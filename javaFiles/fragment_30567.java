public class MyGestureDetector extends GestureDetector {
    public MyGestureDetector(GestureListener listener) {
        super(listener);
    }

    @Override
    public boolean touchUp(float x, float y, int pointer, int button) {
        super.touchUp(x, y, pointer, button);

        // Your Code Here
        return true;
    }
}