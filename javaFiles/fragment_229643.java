public class RandomTestActivity extends Activity {

    private String[] strings;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_test);

        strings = getResources().getStringArray(R.array.OneTimesTables);
        textView= (TextView)findViewById(R.id.RandomTestActivity_textView);
        Button button = (Button)findViewById(R.id.RandomTestActivity_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = (new Random()).nextInt(12);
                textView.setText(""+strings[count]);
            }
        });


        initializeUI();
    }

    private void initializeUI() {
        ArrayList<String> list = new ArrayList<>();

        for(String item: strings){
            list.add(item);
        }

        Collections.shuffle(list);

        for (String item:list){
            Log.d("TAG",""+item);
        }
    }

}