DataHelper myDB=new DataHelper(this);


//double[] data = new double[] {42.6, 24, 17, 15.4};

/** This passes our data out to the JS */
@JavascriptInterface
public String getData() {

    myDB.insert(16.5048, 80.6338);
    myDB.insert(16.5024,80.6432);
    myDB.insert(16.512,80.6216);
    myDB.insert(16.5124,80.6219);

    Cursor cursor=myDB.fetchAllCountries();
    double[] arr=new double[cursor.getCount()];
    int i=0;

    if(cursor.moveToFirst())
    {
        do {
            double data=cursor.getDouble(cursor.getColumnIndex("lat"));
           arr[i]=data;
            i++;

        }while (cursor.moveToNext());

    }




    Log.d(TAG, "getData() called");
    return a1dToJson(arr).toString();
}


@JavascriptInterface
public String getLong() {

    Cursor cursor1=myDB.fetchAllCountries();
    double[] arr1=new double[cursor1.getCount()];
    int i=0;

    if(cursor1.moveToFirst())
    {
        do {
            double data1=cursor1.getDouble(cursor1.getColumnIndex("longt"));
            arr1[i]=data1;
            i++;

        }while (cursor1.moveToNext());

    }




    Log.d(TAG, "getData() called");
    return a1dToJson(arr1).toString();
}


private Activity activity;

public Context getActivity() {
    return activity;
}

public void setActivity(Activity app) {
    this.activity = app;
}

@JavascriptInterface
public void finish() {
    Log.d(TAG, "ArrayApplication.finish()");
    activity.finish();
}

/** Sorry for not using the standard org.json.JSONArray but even in Android 4.2 it lacks
 * the JSONArray(Object[]) constructor, making it too painful to use.
 */
private String a1dToJson(double[] data) {
    StringBuffer sb = new StringBuffer();
    sb.append("[");
    for (int i = 0; i < data.length; i++) {
        double d = data[i];
        if (i > 0)
            sb.append(",");
        sb.append(d);
    }
    sb.append("]");
    return sb.toString();
}