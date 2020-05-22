Context context;
String test;

public MyDataProvider(Context context){
    this.context = context;
    test = context.getString(R.string.E_mc2);
    putInCommonMap();
    putInElectromagneticMap();
}