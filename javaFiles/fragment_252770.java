public void getalldata() {

  // Cursor is loaded with data
  cursor = dbAutoSave.getAllData();
  ArrayList<Data> dataList = new ArrayList<Data>();

  if (cursor != null) {
      cursor.moveToFirst();

       do {
          Data data = new Data();
          data.aaa = cursor.getString(1);
          data.bbb = cursor.getString(2);
          data.ccc = cursor.getColumnName(3);

          // Add into the ArrayList here
          dataList.add(data);

       } while (cursor.moveToNext());

       // Now create the object to be passed to GSON
       DataList listOfData = new DataList();
       listOfData.dataList = dataList;

       Gson gson = new Gson();
       String jsonInString = gson.toJson(listOfData); // Here you go! 

       cursor.close();
   }
}