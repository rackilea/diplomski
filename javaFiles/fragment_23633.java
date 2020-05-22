public class SetLightsActivity extends Activity implements View.OnClickListener {

private ToggleButton toggleButton;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_set_lights);
    this.toggleButton = (ToggleButton)findViewById(R.id.toggleButton1);
    this.toggleButton.setOnClickListener(this);
}

....
@Override
public void onClick(View view) 
{
  if(view == toggleButton) 
  {
    boolean on = toggleButton.isChecked();

    if (on) 
    {
        Uri uri = Uri.parse("http://192.168.0.100/cgi-bin/cgiRelayOn.cgi");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    } 
    else 
    {
          Uri uri = Uri.parse("http://192.168.0.100/cgi-bin/cgiRelayOff.cgi");
          Intent intent = new Intent(Intent.ACTION_VIEW, uri);
          startActivity(intent);
    }
   }
 }
}