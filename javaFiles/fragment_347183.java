...
while(selectResultSet.next()){
     row = new String[columnsNumber];
     for(int i=0;i<columnsNumber;i++){
         row[i] = selectResultSet.getString(i+1);
     }
     System.out.println();
     dataFromQuery.put(ctr++, row);
}
...