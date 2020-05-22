public class MainActivity extends Activity {

    ImageView image = null;
    TextView text = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        text = (TextView) findViewById(R.id.text);
        image = (ImageView) findViewById(R.id.image);

        text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (image.getVisibility() == View.GONE) {
                    image.setVisibility(View.VISIBLE);
                    text.setText("hide the image");
                } else {
                    image.setVisibility(View.GONE);
                    text.setText("show the image");
                }
            }
        });

    }
}