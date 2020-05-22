@Override
 protected void onPostExecute(Void v) {
     ArrayList<SetRows> contents = new ArrayList<SetRows>();
      // other code

       //instead of those
       //sId[m] = id;
       //sType[m] = type;
       //sData[m] = data;
        //add 
       contents.add(new SetRows(id, type, data));
 }