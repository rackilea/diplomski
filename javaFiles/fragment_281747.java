public class Adapter extends RecyclerView.Adapter<Adapter.MyHolder> {

    ArrayList<String> list;

    public Adapter(ArrayList<String> list) {
        this.list = list;
    }


    @Override
    public Adapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_groups, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;

        public MyHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.groupChatNameTxt);
        }

        public void setText(String groupName) {
            nameTextView.setText(groupName);
        }
    }
}