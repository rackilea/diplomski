private Cursor getSuggestions(String query) {
        String[] columns = { MyDBAdapter.KEY_TITLE,MyDBAdapter.KEY_ID};
              Log.d(TAG,"query1: " + query);

              try{
                  MyDB.open();
                  Cursor tmp = MyDB.getAllEntriesFTS(false, columns,
                        null, null, null, null, MyDBAdapter.KEY_TITLE, null, query);
                  MyDB.close();
              Log.d(TAG,"cursor: " + Integer.toString(tmp.getCount()));
              }
              catch(Exception e)
              {
                  Log.d(TAG,e.toString());
              }
              return tmp;
    }