public class MyAdapter extends RecyclerView.Adapter {

    List<String> timeIntervalList = new ArrayList<>();


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view , parent.getContext());

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MyViewHolder viewHolder = (MyViewHolder) holder;

        viewHolder.setItemPosition(position);    
        viewHolder.bind(timeIntervalList.get(position));

    }

    @Override
    public int getItemCount() {
        return timeIntervalList.size();
    }

    public void addItem (String timeText)
    {
        timeIntervalList.add(timeText);
        notifyItemInserted(getItemCount());
    }
}