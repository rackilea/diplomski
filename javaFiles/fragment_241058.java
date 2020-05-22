public class ViewNews extends Activity  {
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.mylayout);
Intent intent = getIntent();
String title= intent.getStringExtra("title");
String description= intent.getStringExtra("description");
TextView titleview =(TextView)findViewById(R.id.title);
titleview.setText(title); 
TextView descriptionview =(TextView)findViewById(R.id.description);
descriptionview .setText(description); 
}