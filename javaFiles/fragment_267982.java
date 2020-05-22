public class Home extends Activity implements OnDrawerScrollListener
{

private ImageView               handleImage;
private Button                  handleButton;
private SlidingDrawer           slide;
    private TextView                tv_commentDisplay;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.main);

            tv_commentDisplay = (TextView)this.findViewById(R.id.tv_commentDisplay);
    handleImage = (ImageView)this.findViewById(R.id.handleImage);
    handleButton = (Button)this.findViewById(R.id.handleButton);
    slide = (SlidingDrawer)this.findViewById(R.id.slide);

    slide.open(); // not sure
    slide.setOnDrawerScrollListener(this);

    handleButton = ((Button)this.findViewById(R.id.handleButton));

    tv_commentDisplay.setText("Hello World");
}

@Override
public void onScrollEnded() {
}

@Override
public void onScrollStarted() {
    if (slide.isOpened())
        handleImage.setImageResource(R.drawable.ic_tray_collapse);
    else {
        handleImage.setImageResource(R.drawable.ic_tray_expand);
    }
}