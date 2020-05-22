sharedPreference.setListener(this);

public class MainActivity extends AppCompatActivity implements RecyclerViewClickListener{
 protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    sharedPreference.setListener(this);
    ....
 }


public class Favourite extends AppCompatActivity implements RecyclerViewClickListener{
 protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_favourite);
    sharedPreference.setListener(this);
    ....
 }