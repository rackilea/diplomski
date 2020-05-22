public abstract class GenericAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<T> items;

    public abstract RecyclerView.ViewHolder setViewHolder(ViewGroup parent);

    public abstract void onBindData(RecyclerView.ViewHolder holder, T val);

    public GenericAdapter(Context context, ArrayList<T> items){
        this.context = context;
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = setViewHolder(parent);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindData(holder,items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItems( ArrayList<T> savedCardItemz){
        items = savedCardItemz;
        this.notifyDataSetChanged();
    }

    public T getItem(int position){
        return items.get(position);
    }
}


adapter = new GenericAdapter<DataModel>(context,modelList) {
        @Override
        public RecyclerView.ViewHolder setViewHolder(ViewGroup parent) {
            final View view =            LayoutInflater.from(context).inflate(R.layout.item_view_holder, parent, false);
            ItemViewHolder viewHolder = new ItemViewHolder(context, view);
            return viewHolder;
        }

        @Override
        public void onBindData(RecyclerView.ViewHolder holder1, DataModel val) {
                DataModel userModel = val;

                ItemViewHolder holder = (ItemViewHolder)holder1;
                holder.name.setText(userModel.getName());
                holder.fatherName.setText(userModel.getFatherName());
        }
    };
    mRecyclerView.setAdapter(adapter);