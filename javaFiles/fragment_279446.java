public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = new TestView(this);
        setContentView(v);
    }

    private static class TestView extends View {
        Paint CircleFill_dah = new Paint(); // hit of dah duration
        ValueAnimator animator_dah = ValueAnimator.ofInt(100,255);

        public TestView (Context context) {
            super(context);
            setFocusable(true);

            CircleFill_dah.setStyle(Paint.Style.FILL);

            CircleFill_dah.setColor(Color.BLUE);
            CircleFill_dah.setAlpha(50);
            animator_dah.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int alphval = (int) animation.getAnimatedValue();
                    CircleFill_dah.setAlpha(alphval);
                    invalidate();
                }
            });

            animator_dah.setDuration(100);
            animator_dah.setRepeatMode(ValueAnimator.REVERSE);
            animator_dah.setRepeatCount(-1);
            animator_dah.start();

        }
        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawCircle(50, 50, 50, CircleFill_dah);
        }
    }
}