public class TextViewMarquee extends Activity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv = (TextView) this.findViewById(R.id.tv);  
        tv.setSelected(true);  // Set focus to the textview
    }
}