public static DefaultTableModel createModel(ResultSet rs){
   DefaultTableModel dtm = new DefaultTableModel();
   Vector rowVectors = new Vector();
   Vector columnHeaderVector = new Vector();

     //To get rows correctly
     int columncount = rs.getMetaData().getColumnCount();

     //Iterating all data and creating rows vector
     while(rs.next())
     {
         //It seems confusing to newbies,
         //for defaultTableModel we need a vector containing rows(as a vector)
         Vector singleRow = new Vector();
         for(int i=1;i<=columncount;i++)
         {
             singleRow.addElement(rs.getObject(i));
         }
         rowVectors.addElement(singleRow);
     }

     //Creating header for table
     for(int i=1;i<=columncount;i++)
     {
         columnHeaderVector.addElement(rs.getMetaData().getColumnName(i));
     }

   //Setting vectors to the model
   dtm.setDataVector(rowVectors, columnHeaderVector);
   return dtm;      }