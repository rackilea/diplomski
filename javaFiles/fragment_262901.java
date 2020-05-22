List<Float> dataList = new ArrayList<Float>();
   msql.query("SELECT * FROM `%s`", tableName); 
   while (msql.next()) { 
   dataList.add(msql.getFloat(2));
   row++;
   }

// copy list to array
float [] data = dataList.toArray(new float[dataList.size()]);