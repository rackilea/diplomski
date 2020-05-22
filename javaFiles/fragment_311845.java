public class historique extends AppCompatActivity {
    private String idc;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabseHelper(this); //<<<<<<<<<<

        ........ rest of the code