public class wordlist extends AppCompatActivity {
    String[] givenWrds = null;

    void go() {
        if(givenWrds ==null) {
            return;
        }

        Intent intent = new Intent(this, timeup.class);
        intent.putExtra("value", givenWrds);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      //... change String[] givenWrds = new String[numWrds]; to below like
      givenWrds = new String[numWrds];
    }
}