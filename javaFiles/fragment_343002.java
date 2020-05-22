public class FooTask extends AsyncTask<Foo, Foo, Foo>
{
    private static boolean bDiscardButtonAction = false;
    private boolean isDiscareded = false;

    @Override
    public void onPreExecute()
    {
        if(bDiscardButtonAction)
        {
            isDiscareded = true;
            return;
        }

        bDiscardButtonAction = true;
    }

    @Override
    public Foo doInBackground(Foo... params)
    {
        if(isDiscareded) return;

        // ...
    }

    @Override
    public void onPostExecute(Void result)
    {
        if(!isDiscareded) bDiscardButtonAction = false;
    }

    @Override
    public void onCancelled(Foo result)
    {
        if(!isDiscareded) bDiscardButtonAction = false;
    }
}