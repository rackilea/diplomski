public class CurrencyRatesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new ReadCurrencyRateTask(this).execute("http://currency.xml");
    }

    class ReadCurrencyRateTask extends AsyncTask<String, Integer, Integer> {

        //your network stuff goes here

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            //your stuff
            setContentView(yourView);
        }

    }

}