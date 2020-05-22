public class MainActivity extends ListActivity {
DatabaseHelper db;
Button knapp1;
Button knapp2;
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

/*  Always initialize after setContentView      */
  db = new DatabaseHelper(MainActivity.this); //This will also work

    knapp1 = (Button) findViewById(R.id.Legg_Til);
    knapp2 = (Button) findViewById(R.id.Les_database);

    knapp2.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {
        visliste();
        }
    });
   knapp1.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {
            LagTabell(db.getWritableDatabase());
        }
    }); 

}