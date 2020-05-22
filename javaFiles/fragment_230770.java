public class MainActivity extends Activity {
    private TextView[ ] answer;


    @Override
    public void onCreate(Bundle savedInstanceState) {
       ...
       answer = new TextView[] { new TextView(this) };
    }
   ....
}