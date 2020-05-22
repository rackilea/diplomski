public class Tester extends Activity {

    String[] vals = { "here", "are", "some", "values" };
    Spinner spinner;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        spinner = (Spinner) findViewById(R.id.spin);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, vals);
        spinner.setAdapter(ad);
        Log.i("", "" + spinner.getChildCount());
        Timer t = new Timer();
        t.schedule(new TimerTask() {

            @Override
            public void run() {
                int a = spinner.getCount();
                int b = spinner.getChildCount();
                System.out.println("Count =" + a);
                System.out.println("ChildCount =" + b);
                for (int i = 0; i < b; i++) {
                    View v = spinner.getChildAt(i);
                    if (v == null) {
                        System.out.println("View not found");
                    } else {
                        v.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                        Log.i("","click");
                                        }
                        });
                    }
                }
            }
        }, 500);
    }
}