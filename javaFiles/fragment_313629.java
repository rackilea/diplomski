public class PremiereActivite extends Activity {

protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button v = (Button) findViewById(R.id.buttonid);

     v.setOnClickListener(new View.OnClickListener() {

     @Override
     public void onClick(View v) {

         Toast.makeText(PremiereActivite.this, "Ceci est mon premier projet !", Toast.LENGTH_LONG).show();         }
 });


}

}