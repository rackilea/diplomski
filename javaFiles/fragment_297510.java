public class MainActivity extends AppCompatActivity { 
Music gm ;

@Override 
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState); 

    // Display the Main Activity. 
    setContentView(R.layout.activity_main); 
      gm = new Music(this); // pass context here to music  
    gm.menuSound(true); 
}