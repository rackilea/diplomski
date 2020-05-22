public class CustProfileActivity extends AppCompatActivity {
 ...// ... means rest of your code

@Override
protected void onCreate(Bundle savedInstanceState) {
 ...
  // missed to initialize phone & email
  phone = findViewById(R.id.phone);
  email = findViewById(R.id.email);
 ...
 }
}