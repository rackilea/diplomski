public class ProgramiPowerlifting5x5 extends AppCompatActivity {
    ...
    // change the method's name to avoid confusion with constuctor
    public void ProgramiPowerLifting(View view){
        Intent intent = new Intent(this, ProgramiPowerlifting5x5.class);
        startActivity(intent);
    }
}