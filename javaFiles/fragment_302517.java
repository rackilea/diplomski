public class MainActivity extends Activity {
    ViewFlipper viewFlipper;
    Button Next;
    private Integer images[] = {R.drawable.ic_launcher,
            R.drawable.ic_no_image, R.drawable.calendar52};
    ImageView imageView1;
    private int currImage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipper = (ViewFlipper) findViewById(R.id.ViewFlipper01);

        Next = (Button) findViewById(R.id.Next);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        Next.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                currImage++;
                if (currImage == 3) {
                    currImage = 0;
                }
                final ImageView imageView = (ImageView) findViewById(R.id.imageView1);
                imageView.setImageResource(images[currImage]);
                viewFlipper.showNext();
            }
        });
    }
}