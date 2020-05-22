public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

public static String s1 ;
public static String s2 ;


    void Method1(View view) {
      s1 = textView.getText().toString();
    }
 void Method2() {
       s2 = s1 ;
    }
}