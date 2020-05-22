public class AfficheurListView extends AppCompatActivity {
    String json_string2;
    String json_string;

    TextView textView;
    String mpx, rds, al, ar, frequence, pilots, id, id_SIGFOX, timestamps, rf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_listview_layout);

        json_string = getIntent().getExtras().getString("json_data");
        json_string2 = getIntent().getExtras().getString("json_Mpx");

        textView = (TextView) findViewById(R.id.textView4);

        try {
            // Json Object {}
            /* Useless, because you use GSON instead of this
            String mpx, rds, al, ar, frequence, pilots, id, id_SIGFOX, timestamps, rf;
            jObj = new JSONObject(json_string);
            mpx = jObj.getString("MPX");
            rds = jObj.getString("RDS");
            rf = jObj.getString("RF");
            frequence = jObj.getString("Frequence");
            timestamps = jObj.getString("timestamp");
            id = jObj.getString("id");
            id_SIGFOX = jObj.getString("id_SIGFOX");
            pilots = jObj.getString("PILOT");
            al = jObj.getString("a_l");
            ar = jObj.getString("a_r");
            Gson gson = new Gson();
            Valeurs valeurs = new Valeurs(mpx, rds, al, ar, frequence, pilots, id, timestamps, id_SIGFOX, rf);*/
            // So, now 'valeurs' and 'valeurs2' are
            Valeurs valeurs = gson.fromJson(json_string, Valeurs.class);
            Valeurs valeurs2 = gson.fromJson(json_string2, Valeurs.class);

            // if your program is here, then you have no parsing error, so set your textView
            textView.setText(valeurs2.getMpx());
        } catch (Exception e) {
            // You have an error
            textView.setText(e.getMessage());
        }
    }
}