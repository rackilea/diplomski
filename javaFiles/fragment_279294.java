public class Wrap
{
    public String dataPassedInOnClick;
    public String resultData;
}

public class JSONTask extends AsyncTask<String, String, Wrap> {
    private Context mContext;
    private View rootView;
    ProgressDialog pDialog;
    JSONTask(Context mContext) {
        this.mContext = mContext;
    }

    public JSONTask(Context context, View rootView){
        this.mContext=context;
        this.rootView=rootView;
    }

    @Override
    protected Wrap doInBackground(String... params) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            Wrap wrapper=new Wrap();
            wrapper.dataPassedInOnClick=params[0];
            wrapper.resultData=buffer.toString();

            return wrapper;


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute(){
        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Loading data...");
        pDialog.show();
    }
    protected void onPostExecute(Wrap wrapResult) {
        super.onPostExecute(wrapResult);
        this.pDialog.dismiss();

        if (wrapResult.dataPassedInOnClick.contains("Honda") ||
                wrapResult.dataPassedInOnClick.contains("honda")) {
            String activity_title =
                    getResources().getString(R.string.Honda);
            Intent intent = new Intent(MainActivity.this,
                    DisplayDataActivity.class);
            Bundle extras = new Bundle();
            extras.putString("title", activity_title);
            extras.putString("JSON_Object", wrapResult.resultData);
            intent.putExtras(extras);
            startActivity(intent);
        } else if (wrapResult.dataPassedInOnClick.contains("Suzuki") ||
                wrapResult.dataPassedInOnClick.contains("suzuki")) {
            String activity_title =
                    getResources().getString(R.string.Suzuki);
            Intent intent = new Intent(MainActivity.this,
                    DisplayDataActivity.class);
            Bundle extras = new Bundle();
            extras.putString("title", activity_title);
            extras.putString("JSON_Object", wrapResult.resultData);
            intent.putExtras(extras);
            startActivity(intent);
        }
    }
}