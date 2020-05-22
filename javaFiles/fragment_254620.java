public class Accueil extends AppCompatActivity {

    BaseSQLite  mybasesqlite;      

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mybasesqlite = new BaseSQLite(this);
        List mylist = mybasesqlite.getNumTicket();

    }
    // if used in another method then
    private void doSomethingElse() {
        List myotherlist = mybasesqlite.getNumTicket();
    }
}