public void addItem(DataObject dataObj, final int index) { 
    if (mActivity == null){ 
    return; 
} 

mActivity.runOnUiThread(new Runnable() { 
    @Override public void run() { 
        mDataset.add(index, dataObj); 
       notifyItemInserted(index); 
    } 
}); 
}