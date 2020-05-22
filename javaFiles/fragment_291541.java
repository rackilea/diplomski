public class SearchEngineAdapter extends RecyclerView.Adapter<SearchEngineAdapter.ViewHolder> {
    private int selectedItem = 0;
    private static RecyclerViewClickListener itemListener;

    private Context context;
    ArrayList<SearchEngine> arrayList = new ArrayList<>();

    // Added another argument to be passed in the constructor
    public SearchEngineAdapter(Context context, ArrayList<SearchEngine> arrayList, int selectedItem) {
        this.context = context;
        this.arrayList = arrayList;
        this.selectedItem = selectedItem;
    }

    @NonNull
    @Override
    public SearchEngineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.s_engine_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int i) {
        if (selectedItem == i) {
            holder.tvIcon.setBackgroundColor(Color.parseColor("#30000000"));
        } else {
            holder.tvIcon.setBackgroundColor(Color.parseColor("#00000000"));
        }

        holder.tvIcon.setImageResource(arrayList.get(i).getIcon());
        holder.tvId.setText(arrayList.get(i).getId());
        holder.tvSearchUrl.setText(arrayList.get(i).getUrl());

        holder.tvIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int PreviousSelectedItem = selectedItem;
                selectedItem = i;
                holder.tvIcon.setBackgroundColor(Color.parseColor("#30000000"));
                notifyItemChanged(PreviousSelectedItem);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvId, tvSearchUrl;
        ImageView tvIcon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.ivEngineText);
            tvIcon = itemView.findViewById(R.id.ivEngine);
            tvSearchUrl = itemView.findViewById(R.id.ivSearchUrl);
        }
    }
}