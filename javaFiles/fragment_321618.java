public class MyView extends View {
        ...
        public void setBall(int pos) {
            myBall.setX(pos);
            myBall.setY(pos);
            invalidate();
        }
    }