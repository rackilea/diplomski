public class database {

    Context _mContext;

    public database(Context c)
    {
        _mContext = c;
    }

    Toast.makeText(_mContext, "Hello Android", 100).show();

}

public class showtoast extends Activity {

    protected void onCreate() {

       database db = new database(showtoast.this);   // calling the constructor and passing the context.
    }

    public toast() {
        Toast.makeText(showtoast.this, "hi toast executed!!", Toast.LENGTH_LONG).show();
    }
}