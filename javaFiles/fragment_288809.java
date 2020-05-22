public class StatAdapter extends BaseAdapter {
    private Activity mActivity;
    private ArrayList<Stat> mData;
    private LayoutInflater mInflater;
    private Drawable drawableOffline,drawableOnline;
    private OnMenuItemClickListener onMenuItemClickListener;

    public StatAdapter(Activity activity, ArrayList<Stat> data,OnMenuItemClickListener onMenuItemClickListener) {
        mActivity = activity;
        mData = new ArrayList<>();
        mData.addAll(data);
        this.onMenuItemClickListener = onMenuItemClickListener;

        mInflater = (LayoutInflater) mActivity.getSystemService(AppCompatActivity.LAYOUT_INFLATER_SERVICE);

         drawableOnline = activity.getResources().getDrawable(R.drawable.round_online);
         drawableOffline = activity.getResources().getDrawable(R.drawable.round_offline);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int pPosition, View pView, ViewGroup pParent) {
        pView = mInflater.inflate(R.layout.list_stat, null,false);

        String name = mData.get(pPosition).getName();
        String first = name.substring(0, 1);

        TextView txtCount = pView.findViewById(R.id.txt_count);

        txtCount.setText(first);

        TextView txtName = pView.findViewById(R.id.txt_name);
        txtName.setText(name);
        TextView txtNumber = pView.findViewById(R.id.txt_number);
        txtNumber.setText("Number: "+mData.get(pPosition).getNumber());

        int onlineBg = ResourcesCompat.getColor(mActivity.getResources(), R.color.onlineBg, null);
        int offlineBg = ResourcesCompat.getColor(mActivity.getResources(), R.color.offlineBg, null);
        int white = ResourcesCompat.getColor(mActivity.getResources(), R.color.colorWhite, null);
        int black = ResourcesCompat.getColor(mActivity.getResources(), R.color.colorBlack, null);


        ImageView btnGetCSV = pView.findViewById(R.id.btnGetCSV);
        ImageView btnNotificationOff = pView.findViewById(R.id.btnNotificationOff);
        ImageView btnNotificationOn = pView.findViewById(R.id.btnNotificationOn);
        ImageView btnNumberDetails = pView.findViewById(R.id.btnNumberDetails);
        ImageView btnRemoveNumber = pView.findViewById(R.id.btnRemoveNumber);

        btnGetCSV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onMenuItemClickListener.onGetCSVClick();
            }
        });
        btnNotificationOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onMenuItemClickListener.onNotificationOffClick();
            }
        });
        btnNotificationOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onMenuItemClickListener.onNotificationOnClick();
            }
        });
        btnNumberDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onMenuItemClickListener.onNumberDetailsClick();
            }
        });
        btnRemoveNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onMenuItemClickListener.onRemoveNumberClick();
            }
        });

        TextView txtSatus = pView.findViewById(R.id.txt_status);
        txtSatus.setText(mData.get(pPosition).isOnline() ? "Online" : "Offline");

        if(mData.get(pPosition).isOnline()){
            txtCount.setCompoundDrawablesWithIntrinsicBounds(drawableOnline,null,null,null);
        }else{
            txtCount.setCompoundDrawablesWithIntrinsicBounds(drawableOffline,null,null,null);
        }


        txtCount.setTextColor(mData.get(pPosition).isOnline() ? white : black);
        txtCount.setBackgroundColor(mData.get(pPosition).isOnline() ? onlineBg : offlineBg);

        TextView txtTime = pView.findViewById(R.id.txt_time);
        txtTime.setText("Since " + mData.get(pPosition).getLastOnline());

        return pView;
    }

    public void setData(ArrayList<Stat> data) {
        mData.clear();
        mData.addAll(data);
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
            }
        });
    }

    public void addData(Stat data) {
        mData.add(data);
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
            }
        });
    }

    public void clearData() {
        mData.clear();
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
            }
        });
    }

    public Stat getStat(int position) {
        return mData.get(position);
    }


    public interface OnMenuItemClickListener
    {
        void onGetCSVClick();
        void onNotificationOffClick();
        void onNotificationOnClick();
        void onNumberDetailsClick();
        void onRemoveNumberClick();
    }
}