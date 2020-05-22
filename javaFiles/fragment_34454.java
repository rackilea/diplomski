public class Main2Activity extends AppCompatActivity {

.
.
.

@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    Intent intent = getIntent();
    setContentView(R.layout.activity_main); // here is issue same layout is used for both activity 
   }
 }