public class EmojiAdapter extends BaseAdapter {

    Context context;
    ArrayList<EmojiModel> list = new ArrayList<>();

    public EmojiAdapter(Context context,ArrayList<EmojiModel> list) {
        super(context, R.layout.smiles_items_layout, list);
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater o =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = o.inflate(R.layout.gifts_layout_2, parent , false);

        ImageView imageView = (ImageView) v.findViewById(R.id.smile_image_view);


        imageView.setImageResource(Integer.parseInt((list.get(position)).urlFile));

        return v;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}