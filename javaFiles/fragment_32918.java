// Default value if row does not exist in preference
public static final String rowExistence = "Row did not exist";

private Context ctx;

public SPAdapter(Context ctx){
    this.ctx = ctx;
}

public String prefGet(String preferenceName, String rowId) {
    SharedPreferences preferenceObject = ctx.getSharedPreferences(
            preferenceName, Context.MODE_PRIVATE);
    String value = preferenceObject.getString(rowId, rowExistence);
    return value;
}