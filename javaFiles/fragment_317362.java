public class Methods_play {

    // create a member variable for your context
    Context mContext;

    //Create the constructor which takes a context
    public void Methods_play(Context c)
    {
         mContext = c;
    }

    public String[] pewpew(int level) {

        //GETS STUFF
        Random rn = new Random(); 

        // Use your context below
        SharedPreferences prefs = mContext.getSharedPreferences(getResources()
               .getString(R.string.preferences), MODE_PRIVATE);
        Editor editor = prefs.edit();