public BoxAdapter extends BaseAdapter {

    Context mContext;
    ArrayList<ItemInfo> objects;

    public BoxAdapter(Context context, ArrayList<ItemInfo> products) {
        mContext = context;
        objects = products;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate and adjust view
    }

    public int getCount() {
        return objects.size();
    }

    public Object getItem(int position) {
        return objects.get(position);
    }

    public void setProducts(ArrayList<ItemInfo> newData) {
        objects = newData;
    }
}