public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter implements AppConstants {

    public SmartArrayList<T> mArrayList;
    public Context mContext;
    private int margin;

    public BaseRecyclerViewAdapter(Context mContext) {
        this.mArrayList = new SmartArrayList<>();
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getView(), parent, false);
        return getViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        if (mArrayList != null && mArrayList.size() > 0) {
            final T obj = mArrayList.get(holder.getAdapterPosition());
            setData(holder, obj, position);
        }
    }


    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public abstract RecyclerView.ViewHolder getViewHolder(View view);

    public abstract int getView();

    public abstract void setData(RecyclerView.ViewHolder holder, T data, int position);

    public void addAll(ArrayList<T> mArrayList) {
        if (null != mArrayList) {
            this.mArrayList.addAll(mArrayList);
            notifyItemRangeInserted(getItemCount(), mArrayList.size());
        }
    }

    public void updateAll(ArrayList<T> mArrayList) {
        this.mArrayList = new SmartArrayList<>();
        this.mArrayList.addAll(mArrayList);
        notifyDataSetChanged();
//        notifyItemRangeInserted(getItemCount(), mArrayList.size());
    }

    public void clear() {
        this.mArrayList.clear();
        notifyDataSetChanged();
    }

    public void update(int position, T obj) {
        this.mArrayList.set(position, obj);
        notifyItemChanged(position);
    }

    public void remove(int position) {
        this.mArrayList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,mArrayList.size());
    }

    public void add(T obj) {
        int position = mArrayList.size();
        this.mArrayList.add(obj);
        notifyItemInserted(position);
    }

    public void add(int position, T obj) {
        this.mArrayList.add(obj);
        notifyItemInserted(position);
    }

    public SmartArrayList<T> getData() {
        return mArrayList;
    }
}