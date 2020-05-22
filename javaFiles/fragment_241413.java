public class MyAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    ArrayList<Item> myItems;

    public MyAdapter(Context context, ArrayList<Item> myItems) {
        this.context = context;
        this.myItems = myItems;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return myItems.size();
    }

    @Override
    public Object getItem(int position) {
        return myItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0; //'0' is the default return value, you may change this if necessary
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;
        Item currentItem = (Item) getItem(position);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_view, null);
            holder = new Holder();

            holder.title = (TextView) convertView.findViewById(R.id.tvTitle);
            holder.uploader = (TextView) convertView.findViewById(R.id.tvUploader);
            holder.timeNView = (TextView) convertView.findViewById(R.id.tvTimeNView);
            holder.duration = (TextView) convertView.findViewById(R.id.tvDuration);
            holder.thumb = (ImageView) convertView.findViewById(R.id.imageView);

            convertView.setTag(holder);

        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.title.setText(currentItem.getTitle());
        holder.uploader.setText(currentItem.getUploader());
        holder.timeNView.setText(currentItem.getTimeNView());
        holder.duration.setText(currentItem.getDuration());

        Picasso.with(context).load("http://img.youtube.com/vi/" + 
                currentItem.getVideoId(‌​) + "/default.jpg").
                placeholder(R.drawable.placeholder).into(holder.thumb);

        return convertView;
    }

    static class Holder {
        TextView title, uploader, timeNView, duration;
        ImageView thumb;
    }
}