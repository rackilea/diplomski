public class Start extends Activity {

    Picture img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_start);

    img = (Picture)findViewById(R.id.imageView);
    img.drawPic();

   }
}

<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:tools="http://schemas.android.com/tools"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:background="#0099cc"
tools:context=".Start">

<!-- The primary full-screen view. This can be replaced with whatever view
     is needed to present your content, e.g. VideoView, SurfaceView,
     TextureView, etc. -->

<!-- This FrameLayout insets its children based on system windows using
     android:fitsSystemWindows. -->

<com.andreiv.snake.util.Picture
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:id="@+id/imageView"
    android:layout_gravity="center" />