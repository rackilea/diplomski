public class MyBringBack extends View {

    // ----------------------------------
    // INTERFACES
    // ----------------------------------

    public interface BringBackListener {
        public abstract void onObservableValueChanged(int value);
    }

    // ----------------------------------
    // CONSTANTS
    // ----------------------------------

    private static final int VALUE_UPDATE_TIMEOUT = 1000;

    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------

    private int mObservableValue = 0;

    private static Handler mHandler;
    private static UpdateObservableValueRunnable mUpdateObservableValueRunnable;

    private BringBackListener mListener;

    // ----------------------------------
    // CONSTRUCTORS
    // ----------------------------------

    public MyBringBack(Context context) {
        super(context);
        initializeView();
    }

    public MyBringBack(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeView();
    }

    public MyBringBack(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyBringBack(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initializeView();
    }

    // ----------------------------------
    // PUBLIC METHODS
    // ----------------------------------

    public void setBringBackListener(BringBackListener listener) {
        mListener = listener;
    }

    // ----------------------------------
    // PRIVATE METHODS
    // ----------------------------------

    private void initializeView() {
        mHandler = new Handler();
        mUpdateObservableValueRunnable = new UpdateObservableValueRunnable();

        mHandler.postDelayed(mUpdateObservableValueRunnable, VALUE_UPDATE_TIMEOUT);
    }

    // ----------------------------------
    // NESTED CLASSES
    // ----------------------------------

    private class UpdateObservableValueRunnable implements Runnable {
        public void run() {
            mObservableValue++;
            if (mListener != null) {
                mListener.onObservableValueChanged(mObservableValue);
            }

            mHandler.postDelayed(mUpdateObservableValueRunnable, VALUE_UPDATE_TIMEOUT);
        }
    }; // UpdateObservableValue

}