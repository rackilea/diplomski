public class MyActivity extends Activity implements MyInterface{

private Bitmap Image;

public void onCreate(Bundle b)
{
    super.onCreate(b);

    new MyTask(this).execute();
}

@Override
public void onPostExecute() {
        //Now you have your bitmap update by do in background 
    //do stuff here 
}


private class MyTask extends AsyncTask<Void, Void, Void>
{
    MyInterface myinterface;

    MyTask(MyInterface mi)
    {
        myinterface = mi;
    }

    @Override
    protected Void doInBackground(Void... params) {
        //firt declare bitmap as class member of MyActivity 
        //update bitmap here and then call

        myinterface.onPostExecute();

        return null;
    }

}

 }