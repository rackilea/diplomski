if(column_exist(att)){
   string q="select " + att + " from EMPLOYEE where salary>?";

   Preparedstatement pst=connectionobject.preparedstatement(q);
   pst.setint(1,10000); 
}