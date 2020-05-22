/** ValueAnimator demo */
public class MainActivity extends Activity {

    ValueAnimator mAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv = (TextView) findViewById(R.id.textview);
        mAnimator = ValueAnimator.ofInt(1, 100).setDuration(1000);
        mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        mAnimator.addUpdateListener(new AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(final ValueAnimator animator) {

                final Integer value = (Integer) animator.getAnimatedValue();
                tv.setText(String.format("%04d", value));
            }

        });
        mAnimator.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animator) {

                super.onAnimationEnd(animator);
                final int endValue = Integer.parseInt((String) tv.getText());
                mAnimator.setIntValues(endValue, endValue + 100);
            }
        });
    }

    /** Button callback */
    public void onClick(final View view) {

        if (!mAnimator.isStarted() && !mAnimator.isRunning()) {
            mAnimator.start();
        }
    }
}