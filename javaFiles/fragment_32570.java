private Context mContext;
public knight(Context context)
{
   mContext=context;
   super();
}
...
Toast.makeText(mContext ,list, Toast.LENGTH_LONG).show();