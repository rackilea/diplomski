public class MyActivity extends Activity implements View.OnClickListener
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Button btn=(Button)findViewById(R.id.mybutton);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        //handle the click event
    }
}