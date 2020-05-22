@Override
public int getCount() {
    if (mData != null) {
         return mData.size() + (
              ((mDataTask.isLoading())        // we are already loading
             || mDataTask.hasMoreResults()    // or there are more results
             || mDataTask.isErrored())     // or there's an error
           ? 1 : 0);
        }
   return 0;
}