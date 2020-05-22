public void addItems(List<Warehouse> items) {
     int oldSize = mDataSet.size();
     synchronized(mDataSet) {
         mDataSet.addAll(items);
     }
     notifyItemRangeInserted(oldSize - 1, mDataSet.size() - 1);
 }