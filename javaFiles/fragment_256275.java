public class listView extends Activity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_layout);

        ArrayList<String> n;
        ArrayList<String> id  = new ArrayList<>();
        ArrayList<String> name  = new ArrayList<>();
        ArrayList<String> email  = new ArrayList<>();
        ArrayList<String> phno  = new ArrayList<>();

        MyDBHandler db = new MyDBHandler(this, null, null, 1);

        n=db.retrieveData();

        for(int i =0; i<n.size();i++){
            if(i%4==0)
                id.add(n.get(i));
            else if (i%4==1)
                name.add(n.get(i));
            else if (i%4==2)
                email.add(n.get(i));
            else
                phno.add(n.get(i));
        }

        System.out.println(n);


        ListAdapter harshitsAdapter = new CustomAdapter(this, id, name, email, phno);

        ListView harshitsListView = (ListView) findViewById(R.id.harshitsListView);
        harshitsListView.setAdapter(harshitsAdapter);




    }

    public void backToMain(View view){

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }





}