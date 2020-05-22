public void updateData(ArrayList<MyDataType> newDataSet){
    myAdapterDataSet = newDataSet;

    // Let the Adapter know the data has changed and the view should be refreshed
    notifyDataSetChanged();
}