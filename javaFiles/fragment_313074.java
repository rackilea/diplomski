<Activity1.java>
    private static MainActivity mInstance;

    public static MainActivity getInstance() {

        return mInstance;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInstance = this;
   }

   public int helloTable ( int INDEX ) {
        int output;

        if(INDEX<5)
        { output=0; }
        else
        { output=1; }

        return output;
    }
<Activity1.java>