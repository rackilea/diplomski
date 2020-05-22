public class GameList extends Fragment {


TextView gm_lst;
Button show;
String str ="" ;

public GameList() {
    // Required empty public constructor
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_game_list, container, false);
   }
 }

 @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    gm_lst = (TextView)getView().findViewById(R.id.game_list);

    new AsyncTask<String, String, String>() {
        protected String doInBackground(String... url) {
            try {
                URL openUrl = new URL("http://localhost:8080/GamingHub/ShowDataServlet");
                HttpURLConnection connection = (HttpURLConnection) openUrl.openConnection();
                connection.setDoInput(true);
              //  Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_LONG).show();
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = "";
                StringBuilder getOutput = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    getOutput.append(line);
                }
                br.close();
                str=line;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }

        protected void OnPostExecute(String otpt)
        {
            gm_lst.setText(otpt);
        }
    }.execute();
    gm_lst.setText(str);

    }