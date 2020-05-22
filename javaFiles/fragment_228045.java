public class MainActivity extends AppCompatActivity {

   TextView resultTextV;

   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       resultTextV = (TextView)findViewById(R.id.resultTextV);
       // ...
   }       
}