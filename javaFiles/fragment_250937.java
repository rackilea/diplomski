private Context mContext;

private DigimonContentProvider(Context context)
{
    this.mContext = context;
}

private DigimonContentProvider() { }


public static DigimonContentProvider getInstance(Context context) {
    if (instance == null)
        instance = new DigimonContentProvider(context);
    return instance;
}

@Override
public boolean onCreate() {
    dbHelper = DBHelper.getInstance(this.mContext);