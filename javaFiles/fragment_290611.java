public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder>
{

    private Context context;
    private ArrayList<POJO> personUtils;

    public CustomRecyclerAdapter(Context context, ArrayList<POJO> personUtils) {
        this.context = context;
        this.personUtils = personUtils;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.djname_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(personUtils.get(position));
        POJO pu = personUtils.get(position);
        holder.djNameView.setText(pu.getName());
        holder.badge.setText(pu.getCount()+"");
    }

    @Override
    public int getItemCount() {
        return personUtils.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView djNameView;
        public TextView badge;
        public ViewHolder(View itemView) {
            super(itemView);
            djNameView = itemView.findViewById(R.id.song_result_dj);
            badge = itemView.findViewById(R.id.song_badge);
        }
    }
}