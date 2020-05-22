public class RetriveDataAdapter extends RecyclerView.Adapter<RetriveDataAdapter.MyViewHolder> {

    private static final String TAG = "RetriveDataAdapter.class";
    private Context ctx;
    private ArrayList<MyBean> dataList;

    @SuppressLint("LongLogTag")
    public RetriveDataAdapter(Context context, ArrayList<MyBean> dataList) {
        this.ctx = context;
        this.dataList = dataList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvContent;

        public MyViewHolder(View view) {
            super(view);

            tvContent = view.findViewById(R.id.tvContent);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_form, parent, false);
        return new MyViewHolder(itemView);
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
         final MyBean bean = dataList.get(position);

        holder.tvContent.setText("Content: " + bean.getContent());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}