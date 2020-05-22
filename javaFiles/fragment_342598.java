class myActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {

        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


        Info = new Authenticate().execute(ContentString).get();
        ItemsStore.SetItems(Info, getApplicationContext());

    }

}

class ItemsStore
{
   public void SetItems(Information info, Context mContext)
   {
            SharedPreferences  localSettings = mContext.getSharedPreferences("FileName",
            Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = localSettings.edit();
            editor.putString("Url", info.Url);
            editor.putString("Email", info.Email);
   }
}