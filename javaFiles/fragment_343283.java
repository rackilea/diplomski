@Override
    public void onPostExecute(Document d){
        if(pd!=null && pd.isShowing()){
               pd.dismiss();
               }
        super.onPostExecute(d);

    }