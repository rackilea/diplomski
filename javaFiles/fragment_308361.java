public class YourClassName extends Activity
{
    @Override 
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);

        // set activity layout
        setContentView(R.layout.some_activity_layout);

        LinearLayout mainActivityLayout = (LinearLayout)findViewById(R.id.main_layout);
        LayoutInflater li = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // then see previous answer
        // loop n times {
            TextView yourTextView = _li.inflate(R.layout.text_view_layout, null);
            mainActivityLayout.addView(yourTextView);
        // } end loop
    }
}