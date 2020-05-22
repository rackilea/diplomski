public class BoxAdapter extends BaseAdapter {
    private final Context context;
    private final LayoutInflater inflater;
    private final ArrayList<ItemInfo> itemInfos;

    private final int loadCount = 10;

    private int count = 10;
    private String name;

    BoxAdapter(Context context, ArrayList<ItemInfo> products) {
        this.context = context;
        this.itemInfos = products;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public ItemInfo getItem(int position) {
        return itemInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void loadAdditionalItems() {
        this.count += this.loadCount;
        if (this.count > this.itemInfos.size()) {
            this.count = this.itemInfos.size();
        }
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.item, parent, false);
        }

        // You should implement the ViewHolder pattern, google for it.

        ItemInfo p = getItem(position);

        if (p.username.contains("null")) {
            name = "Автор: Неизвестен";
        } else {
            name = "Автор: " + p.username;
        }

        ((TextView) view.findViewById(R.id.name)).setText(name);
        return view;
    }

}