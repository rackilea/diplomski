public class MainActivity extends Activity implements ICallInterface {
    SecondClass second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // second.execute();
        second = new SecondClass(this);
        second.execute();

    }

    /*
     * 
     * @Override public void onTaskCompleted(Boolean result) { // TODO
     * Auto-generated method stub if (result) {
     * Log.d("tag","1111111111111 11111111111 True condition ");
     * System.out.println(result); // System.out.println(str);
     * Toast.makeText(getApplicationContext(), " "+result,
     * Toast.LENGTH_LONG).show();
     * 
     * 
     * } else { Log.d("tag","22222222222222222222 False condition "); }
     * 
     * }
     */

    @Override
    public void onTaskCompleted(String result) {
        // TODO Auto-generated method stub

        System.out.println(result);

        // System.out.println(str);
        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG)
                .show();

    }
}


public class SecondClass extends AsyncTask<String, String, String> {
    ICallInterface mCallInterface;

    public SecondClass(ICallInterface mcaCallInterface) {
        // TODO Auto-generated constructor stub
        this.mCallInterface = mcaCallInterface;
    }

    @Override
    protected String doInBackground(String... params) {
        // TODO Auto-generated method stub
        String str = "Hello";
        return str;
    }

    @Override
    protected void onPostExecute(String result) {
        // TODO Auto-generated method stub
        mCallInterface.onTaskCompleted(result);

        super.onPostExecute(result);
    }

}


public interface ICallInterface {
    void onTaskCompleted(String result);

}