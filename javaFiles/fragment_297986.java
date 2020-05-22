public class MyActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //new GetUrl().execute(20);

        // Test XML Files
        //testXMLFiles();

        final Button speakButton = (Button)findViewById(R.id.play);

        speakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                // TODO: DO something!
            }
        });

        final ObjectAnimator horizontalAnimator = ObjectAnimator.ofInt(new ButtonAnimatorHelper(speakButton), "marginLeft", 0, 600);

        horizontalAnimator.setDuration(2000);
        horizontalAnimator.setRepeatCount(ValueAnimator.INFINITE);
        horizontalAnimator.setRepeatMode(ValueAnimator.REVERSE);
        horizontalAnimator.setInterpolator(new LinearInterpolator());

        horizontalAnimator.start();
    }

    /**
     * Helper class for button animation
     */
    private static class ButtonAnimatorHelper {

        final Button mButton;
        /**
         * Default constructor
         * @param speakButton
         */
        public ButtonAnimatorHelper(final Button button) {
            mButton = button;
        }

        public void setMarginLeft(final int margin) {
            final ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) mButton.getLayoutParams();

            params.leftMargin = margin;

            mButton.setLayoutParams(params);
        }
    }
}