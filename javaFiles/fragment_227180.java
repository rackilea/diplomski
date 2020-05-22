private void createQuery(String[] columns) {
   StringBuilder whereClause = new StringBuilder();
   String sep="";
   for(int i = 0, n = columns.length; i < n; ++i) {
      if (shouldselect(columns[i]){
        whereClause.append(sep);
        sep=" AND ";
        whereClause.append(columns[i]);
      }
   }
}