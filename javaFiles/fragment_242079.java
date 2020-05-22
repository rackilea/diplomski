public class MainActivity extends Activity {

private TextView txtView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    txtView = (TextView)findViewById(R.id.txt); //The id could be different 
    String[] arr = getResources().getStringArray(R.array.array);
    txtView.setText(arr[0]); //arr[1], arr[2] , whatever you want to set

}