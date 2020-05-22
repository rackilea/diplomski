@Override
protected void onPostExecute(String s) {
    super.onPostExecute(s);
    if(callback!=null)
        callback.onAsyncFinished();
    }
}