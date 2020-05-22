public class WorkOrderAssetAdapter extends BaseAdapter
{
    private Activity activity;
    private List<WorkorderAsset> workorderAssetList;
    private static LayoutInflater inflater = null;

    // Constructor
    public WorkOrderAssetAdapter(Activity a, List<WorkorderAsset> items)
    {
        workorderAssetList = items;
        activity = a;
        inflater = LayoutInflater.from(activity);
    }

    @Override
    public int getCount() { return workorderAssetList.size(); }

    @Override
    public Object getItem(int position) { return workorderAssetList.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    // view holder for the item
    public static class ViewHolder extends WorkOrderAssetViewHolder
    {
        @Bind(R.id.line_item_text) TextView line_item_text;
        @Bind(R.id.line_item_list) LinearListView list;

        // Adapter, Data Provider and Presenter for the next level.
        public WorkOrderAssetLineItemAdapter adapter;
        public WorkOrderAssetLineItemProvider provider;
        public WorkOrderAssetLineItemPresenter presenter;

        private Activity activity;
        private WorkorderAsset workOrderAsset;

        public VehicleViewHolder(WorkorderAsset asset, final View view, Activity activity_in)
        {
            ButterKnife.bind(this, view);
            workOrderAsset = asset;
            activity = activity_in;
            workOrderAssetLineItemContent = new WorkOrderAssetLineItemContent(((RoadFS)activity.getApplication()).getServer(), ((RoadFS)activity.getApplication()).getApplicationContext());
            workOrderAssetLineItemContent.getWorkOrderAssetLineItems(
                    workOrderAsset.getWorkOrderID(),
                    workOrderAsset.getWorkOrderAssetID(),
                    new iProvideCallback<List<WorkorderAssetLineItem>>() {

                        @Override
                        public void onSuccess(iResponse response) {
                            list.setAdapter(new WorkOrderAssetLineItemAdapter(activity,
                                    (List<WorkorderAssetLineItem>) response.getResponse(),
                                    view));
                        }

                        @Override
                        public void onFailure(iResponse response) {

                        }
                    });

        }

    @Override
    public View getView(final int position, View view, ViewGroup parent)
    {

        WorkorderAsset workOrderAsset;
        workOrderAsset = workorderAssetList.get(position);
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.workorder_detail_workorderasset_vehicle, parent, false);
            holder = new VehicleViewHolder(workOrderAsset, view, activity);
            view.setTag(holder);
        }

        holder.item_text.setText(workOrderAsset.getVIN());

        holder.workOrderAssetLineItemContent = new WorkOrderAssetLineItemContent(((RoadFS) activity.getApplication()).getServer(), activity);
        holder.workOrderAssetLineItemAdapter = new WorkOrderAssetLineItemAdapter(activity, WorkOrderAssetLineItemContent.workorderAssetLineItemList, view);

        return view;
    }
}