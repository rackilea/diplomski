@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    String[] yourArray = getResources().getStringArray(R.array.yourArray);


    if (db.queryTutteParole().getCount() == 0) {

        for (String s : yourArray) {
            String[] splittedArray = s.split(",");
            db.inserisciParole(splittedArray[0], splittedArray[1]);
        }
    }

    db.close();
}