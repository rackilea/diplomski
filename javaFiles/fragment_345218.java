public class FirstActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("Tab Sample Activity ");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getParent(), SecondActivity.class);
                ActivityStack activityStack = (ActivityStack) getParent();
                activityStack.push("SecondActivity", intent);
            }
        });
        setContentView(textView);
    }
}