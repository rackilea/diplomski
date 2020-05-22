public class MainActivity extends AppCompatActivity implements DataInterface 
{

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    new SiteInfo(this).execute("https://code.visualstudio.com/");
    Logger.addLogAdapter(new AndroidLogAdapter());

}

@Override
public void returnData(String result) {
    Logger.e(result);
}

public class SiteInfo extends AsyncTask<String, Void, String> {
    DataInterface dataInterface;

    SiteInfo(DataInterface dataInterface) {
        super();
        this.dataInterface = dataInterface;
    }

    @Override
    protected String doInBackground(String... urls) {

        URL url;
        String result;
        InputStream inputStream;
        BufferedReader bufferedReader;

        try {

            url = new URL(urls[0]);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream = url.openStream()));

            String inputLine;
            final StringBuilder buffer = new StringBuilder();

            while ((inputLine = bufferedReader.readLine()) != null) {
                buffer.append(inputLine);
            }

            bufferedReader.close();
            result = buffer.toString();

            Log.i("download", result);
            inputStream.close();

            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    @Override
    protected void onPostExecute(String result) {
        dataInterface.returnData(result);
    }
}
}