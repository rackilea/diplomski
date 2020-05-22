public class MainActivity extends AppCompatActivity {

        public static String text = "123";
        Button btn;
        public static TextView txt;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
             txt = findViewById(R.id.txt);
             txt.setText(text);

        }
    }