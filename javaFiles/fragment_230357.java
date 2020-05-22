public class Trivia extends Activity {

            @Override
            public void onCreate (Bundle savedInstanceState) {

                super.onCreate (savedInstanceState);
                setContentView (R.layout.sample);

                Button button = (Button) findViewById (R.id.button);
                TextView textView = (TextView) findViewById (R.id.textView);

                Random generator = new Random ();
                int i;

                ArrayList<SampleModel> list = new ArrayList<MainActivity.Trivia.SampleModel>();
                list.add (new SampleModel ("At 5'3 Muggsy Bogues is the smallest player to ever play in the NBA.", R.drawable.ic_launcher));
list.add (new SampleModel ("At 5'3 Muggsy Bogues is the smallest player to ever play in the NBA.", R.drawable.ic_launcher));
list.add (new SampleModel ("At 5'3 Muggsy Bogues is the smallest player to ever play in the NBA.", R.drawable.ic_launcher));
list.add (new SampleModel ("At 5'3 Muggsy Bogues is the smallest player to ever play in the NBA.", R.drawable.ic_launcher));

                i = generator.nextInt (10);
                textView.setText (list.get (i).getQuote());

                button.setOnClickListener (new View.OnClickListener () {
                    @Override
                    public void onClick (View v) {

                        Intent intent = new Intent (Trivia.this, Trivia.class);
                        startActivity (intent);
                    }
                });
            }

            public class SampleModel {

                String quote;
                int    drawable;



                public SampleModel (String quote, int drawable) {

                    super ();
                    this.quote = quote;
                    this.drawable = drawable;
                }

                public String getQuote () {

                    return quote;
                }

                public void setQuote (String quote) {

                    this.quote = quote;
                }

                public int getDrawable () {

                    return drawable;
                }

                public void setDrawable (int drawable) {

                    this.drawable = drawable;
                }

            }
        }