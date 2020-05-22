public class WorkOrderPresenter implements PropertyChangeListener
{

    private View detailView;
    private WorkOrder workOrder; // the object to display
    private List<WorkorderAsset> assetList;

    // Set your bindings to the view, passing the id from the layout.
    @Bind(R.id.workorderasset_list) View serviceItemDetail;
    @Bind(R.id.workorderasset_list_content) LinearListView assets;
    @Bind(R.id.number_of_service_items) TextView numberOfServiceItems;
    @Bind(R.id.total_value) TextView totalView;

    WorkOrderAssetAdapter workOrderAssetAdapter; // an adapter for a child list

    // Constructor
    public WorkOrderPresenter(View view, WorkOrder wo, final Activity activity)
    {
        workOrder = wo;
        detailView = view;
        ButterKnife.bind(this, detailView); //this is where the binding actually happens

        workOrderAssetContent = Provider.GetItems // Load you items for the adapter.

        // My system gives items back asynchronously:
        workOrderAssetContent.getWorkOrderAssets(workOrder.getWorkOrderID(), new iProvideCallback<List<WorkorderAsset>>() {
            @Override
            public void onSuccess(iResponse<List<WorkorderAsset>> response) {
                assetList = response.getResponse();
                numberOfServiceItems.setText(String.valueOf(assetList.size()));
                workOrderAssetAdapter = new WorkOrderAssetAdapter(activity, assetList); // construct the adapter with items.
                assets.setAdapter(workOrderAssetAdapter);
            }

            @Override
            public void onFailure(iResponse<List<WorkorderAsset>> response) {
                Toast.makeText(activity.getApplicationContext(), R.string.ServiceItemsError, Toast.LENGTH_LONG);

            }
        });
    }
}