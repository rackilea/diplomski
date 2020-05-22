public class MyActivity extends Activity implements OnClickListener 
{
    private Button b;

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        b=new Button();
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) 
    {
        method();
    }

    private void method()
    {
        ...
    }

    public Button getButton()
    {
        return b;
    }
}