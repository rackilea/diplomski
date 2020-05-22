public class MainActivity extends AppCompatActivity {

    ScrollView scrollView;
    int amountToScroll = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = findViewById(R.id.scrollview);
        scrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                scrollView.scrollBy(0, amountToScroll);
                amountToScroll = 0;
            }
        });
        startImageDownload();
        simulateImageScroll();
    }

    private void simulateImageScroll() {
        // scroll to the bottom of the scroll view
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.scrollTo(0, scrollView.getMaxScrollAmount());
            }
        });
    }

    private void startImageDownload() {
        Handler handler = new Handler(getMainLooper());
        // simulate a delay for the image download to illustrate the flashing problem in the scrollview
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                displayImage("");
            }
        }, 2000);

    }

    // when the image is downloaded we add it to the image container
    private void displayImage(String imageFilename) {
        // dynamically create an image and add it to the image container layout
        RelativeLayout container = findViewById(R.id.imageContainer);
        ImageView img = new ImageView(this);

        // image should be loaded from the given filename - for now use a solid background and fixed height
        img.setBackgroundColor(Color.BLUE);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, 500);
        container.addView(img, params);

        adjustScrolling(container);
    }

    private void adjustScrolling(RelativeLayout container) {
        // adjust scroll if the image is loaded before the current content
        if (scrollView.getScrollY() > container.getTop()) {
            container.measure(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            amountToScroll = container.getMeasuredHeight();
        }
    }
}