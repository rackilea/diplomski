public class messagewebview extends AppCompatActivity { 

        TextView testing_name; 

        @Override protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_messagewebview);
          // Provide a appropriate view id
          testing_name = findViewById(R.id.testing_name);
          SharedPreferences loginData = getSharedPreferences("userInfo", Context.MODE_PRIVATE); 
          String name = loginData.getString("userName", ""); 
          String pw = loginData.getString("password","");
           String msg = "Saved User Name: " + name + "\nSaved Password: " + pw;
            testing_name.setText(msg);

        }

        }