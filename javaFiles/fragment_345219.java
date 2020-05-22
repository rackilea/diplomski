public class SecondActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("First Stack Activity ");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getParent(), ThirdActivity.class);
                ActivityStack activityStack = (ActivityStack) getParent();
                activityStack.push("ThirdActivity", intent);
            }
        });
        setContentView(textView);
    }
}