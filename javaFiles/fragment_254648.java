List<WorkOrderItem> mWorkOrderList...
RealmList<WorkOrderItem> mRealmList... //WorkOrderItem need to be a RealmObject


...new Callback<List<WorkOrderItem> mWorkOrderList>() {

    @Override
    public void success(List<WorkOrderItem> mWorkOrderList, Response response) {

        for(WorkOrderItem mWorkOrderItem : mWorkOrderList){

            //create WorkOrderItemRealm
            WorkOrderItemRealm mWorkOrderItemRealm = realm.createObject(WorkOrderItemRealm.class); 

            //mWorkOrderItemRealm.set...(mWorkOrderItem.get...());

            mRealmList.add(WorkOrderItemRealm);
        }
    }

    @Override
    public void failure(RetrofitError error) {

    }
});