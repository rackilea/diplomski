public class ResultsGp extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {

    ...........
    ...........
    ListView list = (ListView)findViewById(R.id.resultsGpList); 

    ResultGpRowAdapter adapter = new ResultGpRowAdapter(this,  R.layout.activity_result_gp_row, new ArrayList<RaceResult>()); //Empty data

   list.setAdapter(adapter);

   .... 
   ....
   ....
   //LOAD a ArrayList<RaceResult> with data

   ArrayList<RaceResult> data = new ArrayList<RaceResult>();
   data.add(new RaceResult(....));
   data.add(new RaceResult(....));
   .......

   adapter.myAddAll(data); //Your list will be udpdated!!!