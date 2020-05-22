class CustomAdapter extends BaseAdapter
    {

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mItemName.size;
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {
        // TODO Auto-generated method stub

        LayoutInflater inf=getLayoutInflater();
        View v=inf.inflate(R.layout.iconrow, arg2,true);

        ImageView iv=(ImageView)v.findViewById(R.id.icon);
        TextView tv=(TextView)v.findViewById(R.id.text);

        return v;
    }

}