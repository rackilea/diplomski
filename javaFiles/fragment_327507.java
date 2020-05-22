public class UploadedDrugsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<UploadedDrugs> dataList = new ArrayList<>();
    private OnClickUploadedDrugs event;

    public UploadedDrugsAdapter (List<UploadedDrugs> dataList, OnClickUploadedDrugs event) {
        this.dataList = dataList;
        this.event = event;
    }

    public interface OnClickUploadedDrugs{
        void onClickUploadedDrugs(UploadedDrugs uploadedDrugs);
    }

    public void changeDataSet(List<UploadedDrugs> dataSet){
        dataList = dataSet;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.your_xml_file, parent, false);

        return new ViewHolderUploadedDrugs(view);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        try {
            final UploadedDrugs model = dataList.get(position);
            final ViewHolderUploadedDrugs vh = (ViewHolderUploadedDrugs) holder;

            // configure view values

            //Event
            vh.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(event != null){
                        event.onClickUploadedDrugs(model);
                    }
                }
            });
        }catch (Exception e){
            Log.e(getClass().getSimpleName(), "Erro ao exibir informaçeõs", e);
        }
    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }

    static class ViewHolderUploadedDrugs extends RecyclerView.ViewHolder {

        TextView drugName;
        ImageView drugImage;


        ViewHolderUploadedDrugs(View itemView) {
            super(itemView);
            this.drugName= (TextView) itemView.findViewById(R.id.shopName);
            this.drugImage= (ImageView) itemView.findViewById(R.id.model_menu);
        }
    }

    public List<UploadedDrugs> getDataList() {
        return dataList;
    }

    public void setEvent(OnClickUploadedDrugs event) {
        this.event = event;
    }
}