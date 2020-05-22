public class custom_dialog extends Dialog implements View.OnClickListener {

  @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yourLayout);
        findViewById(R.id.blue0).setOnClickListener(this);
    }

}