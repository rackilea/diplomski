private void getData() {
   DataDB db = new DataDB();

   try{
       ArrayList<DataBag> dataList= db.searchData(); //select * from ..
       Collections.sort(dataList, getComparator());

       for (DataBag data : dataList) {
          String name= data.getName();
          cboPloegen.getItems().add(name);    
       }

   } catch (ApplicationException ae) {
   } catch (DBException ae) {
 }