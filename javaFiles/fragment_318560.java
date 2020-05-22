public class TimeZoneAdapter extends RecyclerView.Adapter<TimeZoneAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(TimezoneModel item);
    }

    private Context c;
    private List<TimezoneModel> tzmodel;
    private final OnItemClickListener listener;

    public TimeZoneAdapter(Context c, List<TimezoneModel> tzModel, OnItemClickListener listener) {
        this.c = c;
        this.tzmodel = tzModel;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(tzmodel.get(position), listener);
    }

    @Override
    public int getItemCount() {

        return tzmodel.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView timeTxt, currenttimeTxt, regionTxt;

        public ViewHolder(View itemView) {

            super(itemView);
            timeTxt= itemView.findViewById(R.id.timeTxt);
            currenttimeTxt= itemView.findViewById(R.id.currentTimeTxt);
            regionTxt= itemView.findViewById(R.id.regionTxt);
        }

        public void bind(TimezoneModel item , final OnItemClickListener listener) {

            this.timeTxt.setText(item.getTime());
            this.currenttimeTxt.setText(item.getCurrentTime());
            this.regionTxt.setText(item.getRegion());

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override public void onClick(View v) {
                    listener.onItemClick((TimezoneModel) tzmodel);
                }
            });
        }
    }
}