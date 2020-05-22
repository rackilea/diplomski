private void GetData()
    {

    MobileServiceTable<TodoItem> mTable = mobileServiceClient.getTable(TodoItem.class);
    MobileServiceList<TodoItem> results;

    new AsyncTask<Void, Void, Void>() {

          @Override
          protected Void doInBackground(Void... params) {
             try {
                 results = mTable.execute().get(100, TimeUnit.MILLISECONDS);
                 Log.d("debug","data success");
                 }
             catch(Exception e)
                 {

                 }
            return null;
           }
       }.execute();
    }