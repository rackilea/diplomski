class AdapterView extends LinearLayout {        
        public AdapterView(Context context, 
                DB_Get_Values list ) {
            super( context );

            this.setOrientation(HORIZONTAL);        

            LinearLayout.LayoutParams PkeyParams = 
                new LinearLayout.LayoutParams(40, LayoutParams.WRAP_CONTENT);
            PkeyParams.setMargins(1, 1, 1, 1);

            TextView Pkey = new TextView( context );
            Pkey.setText( list.get_P_Key() );
            Pkey.setTextSize(14f);
            Pkey.setTextColor(Color.WHITE);
            addView( Pkey, PkeyParams);

            LinearLayout.LayoutParams MacAddrParams = 
                new LinearLayout.LayoutParams(100, LayoutParams.WRAP_CONTENT);
            MacAddrParams.setMargins(1, 1, 1, 1);
            TextView MacAddr = new TextView( context );
            MacAddr.setText( list.get_Mac_addr() );
            MacAddr.setTextSize(14f);
            MacAddr.setTextColor(Color.WHITE);
            addView( MacAddr, MacAddrParams);

            LinearLayout.LayoutParams SDK_VRSParams = 
                new LinearLayout.LayoutParams(20, LayoutParams.WRAP_CONTENT);
            SDK_VRSParams.setMargins(1, 1, 1, 1);
            TextView SDK_VRS = new TextView( context );
            SDK_VRS.setText( list.get_SDK_VRS() );
            SDK_VRS.setTextSize(14f);
            SDK_VRS.setTextColor(Color.WHITE);
            addView( SDK_VRS, SDK_VRSParams);
}
}
public class DBAdapter extends BaseAdapter {

    private Context context;
    private List<DB_Get_Values> list;

    public DBAdapter(Context context, List<DB_Get_Values> list ) {
        this.context = context;
        this.list = list;
    }

    public int getCount() {
        return list.size();
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return position;
    }
}