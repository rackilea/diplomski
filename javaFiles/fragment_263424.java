String preferences_name = "isFirstTime";

 @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

   ...

    firstTime();
}
...

public  void  firstTime(){

    SharedPreferences sharedTime = getSharedPreferences(preferences_name,0); 
    if (sharedTime.getBoolean("firstTime",true))
    {

        //Your tutorial code

        sharedTime.edit().putBoolean("firstTime",false).apply();
    }
    else
    {
        //When not using tutorial code

   }

}